/**
 * 
 */
package io.swagger.dbconnection;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.swagger.Swagger2SpringBoot;

/**
 * @author maria
 *
 */
public class DbUtil {
 
//    public static void close(Connection connection) {
//        if (connection != null) {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                /*Ignore*/
//            }
//        }
//    }
// 
//    public static void close(Statement statement) {
//        if (statement != null) {
//            try {
//                statement.close();
//            } catch (SQLException e) {
//                /*Ignore*/
//            }
//        }
//    }
// 
//    public static void close(ResultSet resultSet) {
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                /*Ignore*/
//            }
//        }
//    }
	
	public static final String JOBS_TABLE = "AvailableJobs";

	public static String getDBUserName(){
		return Swagger2SpringBoot.properties.getProperty("dbconnection.user", null);		
	}
	
	public static String getDBPassword(){
		return Swagger2SpringBoot.properties.getProperty("dbconnection.password", null);		
	}
    
    public static String getConnectionStringWithOptionsForDatabase(String db){
    	String dbConnectionString = Swagger2SpringBoot.properties.getProperty("dbconnection.string", null);
    	String dboptions = Swagger2SpringBoot.properties.getProperty("dbconnection.options", null);
    	return dbConnectionString + db + "?" + dboptions;
    }
}
