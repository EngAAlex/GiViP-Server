package io.swagger.api;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;
import io.swagger.dbconnection.DbUtil;
import io.swagger.model.BlockDetailsPerElement;
import io.swagger.model.Computation;
import io.swagger.model.Edge;
import io.swagger.model.Latency;
import io.swagger.model.SuperstepBlock;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-02-22T11:32:19.455Z")

@Controller
public class SuperstepBlockApiController implements SuperstepBlockApi {

	@CrossOrigin(origins = "http://localhost")
	public ResponseEntity<List<SuperstepBlock>> superstep(@ApiParam(value = "jobId", required = true) @RequestParam(value = "job", required = true) String job,
			@ApiParam(value = "start index of superstep", required = true) @RequestParam(value = "startIndex", required = true) Integer startIndex,
			@ApiParam(value = "end index of superstep", required = true) @RequestParam(value = "endIndex", required = true) Integer endIndex,
			@ApiParam(value = "size of superstep to aggregate", required = true) @RequestParam(value = "blockSize", required = true) Integer blockSize,
			@ApiParam(value = "desired hierarchy scale", required = true) @RequestParam(value = "scale", required = true) String scale) {
		//    //The database already exists (DataMerge module created and filled it)
		Connection connection = null;
		PreparedStatement st = null;
		ResultSet rs= null;
		Edge e;
		HashMap<String, int[]> ioUnitsMap = new HashMap<String, int[]>();
		HashMap<String, int[]> ioBytesMap = new HashMap<String, int[]>();		
		ArrayList<SuperstepBlock> superstepsBlockList = new ArrayList<SuperstepBlock>();
		SuperstepBlock sb;
		int start = startIndex;
		int end = endIndex;
		int blockCursor = 0;
		int numberOfBlock = 0;
		double timeIndex = 0;
		
		String superstepDetailsQuery = "SELECT element_index, SUM(computation_time), AVG(processed_vertices) AS reported_duration " + 
				"FROM superstepinfo_per_" + scale + " " +
				" WHERE id_superstep BETWEEN ? AND ? GROUP BY (element_index) ORDER BY element_index ASC";


		String superstepDurationQuery = "SELECT SUM(millis) "
				+ "FROM superstepinfo "
				+ "WHERE superstepId BETWEEN ? AND ?";


		String aggregateSuperstepQuery = "SELECT source, target, SUM(nMessages) AS totMessages, SUM(bytes) AS totBytes "
				+"FROM messages_by_"+ scale + " " 
				+"WHERE superstepId BETWEEN ? AND ? "
				+"GROUP BY source, target";
		
		String aggregateLatencyQuery = "SELECT source, target, AVG(latency) AS latency "
				+"FROM latencies " 
				+"WHERE id_superstep BETWEEN ? AND ? "
				+"GROUP BY source, target";

		String computationsCountQuery = "SELECT computation, COUNT(computation) as occurrencies "
				+"FROM superstepinfo " 
				+"WHERE superstepId BETWEEN ? AND ? "
				+"GROUP BY computation";
		
		try{

			connection = DriverManager.getConnection(DbUtil.getConnectionStringWithOptionsForDatabase(DbUtil.JOBS_TABLE), DbUtil.getDBUserName(), DbUtil.getDBPassword());
			st = connection.prepareStatement("SELECT * FROM JobsList WHERE jobId = ?");
			st.setString(1, job);
			st.executeQuery();
			rs = st.getResultSet();
			//Catch job's selected informations
			rs.next();
			int nSuperstep = rs.getInt("nSuperstep");

			nSuperstep -= 1;

			rs.close();
			st.close();

			connection.close();			

			if(start < 0)
				start = 0;
			if(end > nSuperstep)
				end = nSuperstep;
			
			connection = DriverManager.getConnection(DbUtil.getConnectionStringWithOptionsForDatabase(job), DbUtil.getDBUserName(), DbUtil.getDBPassword());
			
			if(start != 0){
				st = connection.prepareStatement(superstepDurationQuery);
				st.setInt(1, 0);
				st.setInt(2, start);
				
				rs = st.executeQuery();
				
				rs.next();
				
				timeIndex = rs.getDouble(1);
				
				rs.close();
				st.close();
			}
				

			blockCursor = (start-1) + blockSize;

			while (blockCursor <= end && start<=end){ 
				//            && blockCursor <= nSuperstep && start<= nSuperstep ){  
				sb = new SuperstepBlock();
				sb.numberOfBlock(numberOfBlock);
				sb.scale(scale);
				sb.nstep((blockCursor-start + 1));

				st = connection.prepareStatement(superstepDurationQuery);

				st.setInt(1, start);
				st.setInt(2, blockCursor);

				st.executeQuery();
				rs = st.getResultSet();
				rs.next();
				sb.duration(rs.getDouble(1));
				sb.setTimeIndex(timeIndex);
				timeIndex += rs.getDouble(1);

				rs.close();
				st.close();

				st = connection.prepareStatement(aggregateSuperstepQuery);

				//				st.setString(1, "messages_by_"+scale);
				st.setInt(1, start);
				st.setInt(2, blockCursor);				
				st.executeQuery();
				rs = st.getResultSet();

				while (rs.next()){
					String source = rs.getString("source");
					String target = rs.getString("target");
					int messagesExchanged = rs.getInt("totMessages");
					int bytes =rs.getInt("totBytes");

					if(!ioUnitsMap.containsKey(source))
						ioUnitsMap.put(source, new int[3]);

					if(!ioUnitsMap.containsKey(target))
						ioUnitsMap.put(target, new int[3]);

					if(!ioBytesMap.containsKey(source))
						ioBytesMap.put(source, new int[3]);

					if(!ioBytesMap.containsKey(target))
						ioBytesMap.put(target, new int[3]);

					if(source.equals(target)){
						ioUnitsMap.get(source)[2] += messagesExchanged;
						ioBytesMap.get(source)[2] += bytes;
					}else{

						e = new Edge();
						e.source(source);
						e.target(target);
						e.messagesExchanged(messagesExchanged);
						e.setSize(bytes);
						sb.addEdgesItem(e);
						
						ioUnitsMap.get(source)[1] += messagesExchanged;
						ioUnitsMap.get(target)[0] += messagesExchanged;

						ioBytesMap.get(source)[1] += bytes;
						ioBytesMap.get(target)[0] += bytes;
					}
					
				}

				rs.close();
				st.close();

				//RETRIEVE SUPERSTEP DETAILS

				st = connection.prepareStatement(superstepDetailsQuery);

				st.setInt(1, start);
				st.setInt(2, blockCursor);

				st.executeQuery();
				rs = st.getResultSet();
				while(rs.next()){
					String elementIndex = rs.getString(1);

					int[] currentUnits = ioUnitsMap.get(elementIndex);
					int[] currentBytes = ioBytesMap.get(elementIndex);

					BlockDetailsPerElement sdw = new BlockDetailsPerElement();
					sdw.setElementIndex(elementIndex);
					sdw.setDuration(rs.getDouble(2));
					sdw.setComputedVertices(rs.getBigDecimal(3));
					if(currentUnits != null){
						sdw.setTotalTrafficMessages(new int[]{currentUnits[0], currentUnits[1]});
						sdw.setTotalTrafficBytes(new int[]{currentBytes[0], currentBytes[1]});
						sdw.setSelfMessages(new BigDecimal(currentUnits[2]));
						sdw.setSelfBytes(new BigDecimal(currentBytes[2]));
					}else{
						sdw.setTotalTrafficMessages(new int[]{0, 0});
						sdw.setTotalTrafficBytes(new int[]{0, 0});
						sdw.setSelfMessages(new BigDecimal(0));
						sdw.setSelfBytes(new BigDecimal(0));						
					}
					sb.addSuperstepsItem(sdw);					
				}			

				rs.close();
				st.close();
				
				//RETRIEVE LATENCIES DATA
				
				st = connection.prepareStatement(aggregateLatencyQuery);

				st.setInt(1, start);
				st.setInt(2, blockCursor);

				st.executeQuery();
				rs = st.getResultSet();
				while(rs.next()){
					Latency ly = new Latency();
					ly.setSource(rs.getString(1));
					ly.setTarget(rs.getString(2));
					ly.setLatency(rs.getInt(3));
					sb.addLatenciesItem(ly);					
				}
								
				rs.close();
				st.close();

				//RETRIEVE COMPUTATIONS INFORMATION
				
				st = connection.prepareStatement(computationsCountQuery);

				st.setInt(1, start);
				st.setInt(2, blockCursor);

				st.executeQuery();
				rs = st.getResultSet();
				while(rs.next()){
					Computation cp = new Computation();
					cp.setClassname(rs.getString(1));
					cp.setOccurrencies(rs.getInt(2));
					sb.addComputationsItem(cp);
				}
								
				rs.close();
				st.close();
				
				superstepsBlockList.add(sb);

				start += blockSize;
				blockCursor = Math.min(blockCursor+blockSize, end);
				numberOfBlock++;
				
				ioUnitsMap.clear();
				ioBytesMap.clear();

			}					

		} catch (Exception exp) {
			exp.printStackTrace();
		}finally{
			try{
				rs.close();
				st.close();
				connection.close();
			}catch(Exception se){

			}
			//			DbUtil.close(rs);
			//			DbUtil.close(st);
			//			DbUtil.close(connection);
		}


		return new ResponseEntity<List<SuperstepBlock>>(superstepsBlockList,HttpStatus.OK);
	}

}
