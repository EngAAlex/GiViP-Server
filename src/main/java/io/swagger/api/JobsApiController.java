package io.swagger.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import io.swagger.Swagger2SpringBoot;
import io.swagger.dbconnection.DbUtil;
import io.swagger.model.Job;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

@Controller
public class JobsApiController implements JobsApi {

	public ResponseEntity<List<Job>> jobList() {
		// do some magic!
		ArrayList<Job> jobList = new ArrayList<Job>();
		Connection connection = null;
		try {
			String dbConnectionUser = Swagger2SpringBoot.properties.getProperty("dbconnection.user", null);
			String dbConnectionPassword = Swagger2SpringBoot.properties.getProperty("dbconnection.password", null);

			connection = DriverManager.getConnection(DbUtil.getConnectionStringWithOptionsForDatabase(DbUtil.JOBS_TABLE), dbConnectionUser, dbConnectionPassword);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Job job;
		ResultSet rs = null;
		Statement st = null;
		String getJobs = 
				"SELECT * FROM JobsList";

		try {
			st = connection.createStatement();
			st.executeQuery(getJobs);
			rs = st.getResultSet();
			while(rs.next()){
				job = new Job();
				job.id(rs.getString("jobId"));
				job.date(new DateTime(rs.getString("date")));
				job.nworkers(rs.getInt("nWorkers"));
//				job.nhosts(rs.getInt("nHost"));
//				job.nracks(rs.getInt("nRack"));
//				job.nsupersteps(rs.getInt("nSuperstep"));
				jobList.add(job);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			//      dao.closeAll();
			try {
				rs.close();
				st.close();

				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return new ResponseEntity<List<Job>>(jobList,HttpStatus.OK);
	}

}
