package io.swagger.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.dbconnection.DbUtil;
import io.swagger.model.Host;
import io.swagger.model.JobInfo;
import io.swagger.model.Rack;
import io.swagger.model.Worker;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-05-04T19:31:31.674Z")

@Controller
public class JobInfoApiController implements JobInfoApi {
	
	@CrossOrigin(origins = "http://localhost")
	public ResponseEntity<JobInfo> jobinfo(@ApiParam(value = "job id", required = true) @RequestParam(value = "jobid", required = true) String jobid) {

		JobInfo jobInfo = new JobInfo();
		//		Rack rack = new Rack();
		//		Host host = new Host();
		//		Worker worker = new Worker();

		double totalDuration = 0;
		long totalMessages = 0;
		long totalBytes = 0;
//		ArrayList<Rack> racklist = new ArrayList<Rack>();
//		ArrayList<JobInfo> = new ArrayList<>();

		PreparedStatement st = null;
		Connection connection = null;
		Connection connectionToJobsList = null;
		ResultSet rs= null;


		try {
			connection = DriverManager.getConnection(DbUtil.getConnectionStringWithOptionsForDatabase(jobid), DbUtil.getDBUserName(), DbUtil.getDBPassword());
			connectionToJobsList = DriverManager.getConnection(DbUtil.getConnectionStringWithOptionsForDatabase(DbUtil.JOBS_TABLE), DbUtil.getDBUserName(), DbUtil.getDBPassword());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String generalInfoQuery = 
				"SELECT * FROM JobsList WHERE jobId = ?";
		
		String totalDurationQuery = 
				"SELECT SUM(millis) "
						+ "FROM superstepinfo ";
		
		String totalQuantitiesQuery =
				"SELECT SUM(%QUANTITY) "
					+ "FROM messages_by_worker";
		
		String hierarchyQuery = 
				"SELECT * "
						+ "FROM hierarchy "
						+ "WHERE typeOfRelation = ?";
		
		String fatherQueryExtension = " and father = ?";

		
		
//		String computationNamesQuery = "SELECT  " +
//										"FROM superstepinfo ORDER BY superstepId ASC";
		
//		String superstepDetailsQuery = "SELECT superstepId, computation, id_worker, computation_time, processed_vertices, millis AS reported_duration " + 
//										"FROM superstepinfo " +
//										"LEFT JOIN superstepinfo_per_worker " +
//											"ON superstepinfo.superstepId = superstepinfo_per_worker.id_superstep " +
//										" WHERE id_superstep >= 0 ORDER BY id_superstep, id_worker ASC";

		try {
			
			//RETRIEVE JOB INFO
			
			st = connectionToJobsList.prepareStatement(generalInfoQuery);

			st.setString(1, jobid);
			
			st.executeQuery();
			rs = st.getResultSet();
			rs.next();
			
			jobInfo.setNworkers(rs.getInt("nWorkers"));
			jobInfo.setNhosts(rs.getInt("nHost"));
			jobInfo.setNracks(rs.getInt("nRack"));
			jobInfo.setNsupersteps(rs.getInt("nSuperstep"));
			
			st.close();
			rs.close();
			
			//RETRIEVE JOB TOTAL DURATION
			st = connection.prepareStatement(totalDurationQuery);

			st.executeQuery();
			rs = st.getResultSet();
			rs.next();
			totalDuration = rs.getDouble(1);

			st.close();
			rs.close();

			jobInfo.setComputationDuration(totalDuration);					
   			
			//RETRIEVE TOTAL BYTES AND MESSAGES
			
			st = connection.prepareStatement(totalQuantitiesQuery.replace("%QUANTITY", "nMessages"));

			st.executeQuery();
			rs = st.getResultSet();
			rs.next();
			totalMessages = rs.getLong(1);

			st.close();
			rs.close();

			jobInfo.setNMessages(totalMessages);
			
			st = connection.prepareStatement(totalQuantitiesQuery.replace("%QUANTITY", "bytes"));

			st.executeQuery();
			rs = st.getResultSet();
			rs.next();
			totalBytes = rs.getLong(1);

			st.close();
			rs.close();

			jobInfo.setBytes(totalBytes);
			
			//RETRIEVE HIERARCHY
			
			ArrayList<String> checked = new ArrayList<String>();

			st = connection.prepareStatement(hierarchyQuery);

			st.setInt(1, 1);
			st.executeQuery();

			rs = st.getResultSet();
			while(rs.next()){
				if( !checked.contains(rs.getString("father")) ){
					checked.add(rs.getString("father"));

					Rack r = new Rack(rs.getString("father"));


					PreparedStatement sh = null, sw = null;
					ResultSet hostList = null, workerList = null;

					try{
						sh = connection.prepareStatement(hierarchyQuery + fatherQueryExtension);
						sh.setInt(1, 1);
						sh.setString(2, rs.getString("father"));
						
						sh.executeQuery();
						ResultSet hostlist = sh.getResultSet();
						
						while(hostlist.next()){
							if( !checked.contains(hostlist.getString("child")) ){
								checked.add(hostlist.getString("child"));
								Host h = new Host(hostlist.getString("child"));
								
								sw = connection.prepareStatement(hierarchyQuery + fatherQueryExtension);
								
								sw.setInt(1, 0);
								sw.setString(2, hostlist.getString("child"));								
								sw.executeQuery();
								
								workerList = sw.getResultSet();
								
								while(workerList.next()){
									Worker w = new Worker(workerList.getString("child"));                   
									h.addChild(w);
								}
								r.addChild(h);
								
								sw.close();
								workerList.close();
							}
						}
						
						hostlist.close();
						sh.close();
						
						jobInfo.getRacklist().add(r);
					}catch(SQLException se){
							se.printStackTrace();
							try{
								sh.close();
								sw.close();
								hostList.close();
								workerList.close();
							}catch(Exception e){}
							throw new SQLException(se);
						}
					}
				}

				rs.close();
				st.close();

//				for(Rack r: racklist){
//					jobInfo.getRacklist().add(r);					
//				}
				//			System.out.println(jobInfo.toString());
				//			System.out.println(checked);


			} catch (SQLException e) {
				e.printStackTrace();
			}          
			finally{
				try {
					connection.close();
					connectionToJobsList.close();

				} catch (SQLException e) {
				}
			}

			return new ResponseEntity<JobInfo>(jobInfo, HttpStatus.OK);
		}

	}

