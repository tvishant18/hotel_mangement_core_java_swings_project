package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseManager {
 public static Connection getconnection() throws SQLException{
	 Connection connection=null;
	 try {
		Class.forName(Constants.DRIVER_NAME);
	   
	 } catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	 connection=DriverManager.getConnection(Constants.CONNECTION_STRING, Constants.DB_USERNAME, Constants.DB_PASSWORD);
    	
	return connection;
 }
	
	public static void close_all_connection(Connection conn,PreparedStatement  pstmt,ResultSet resultset)throws SQLException{
		close_connection(conn);
		close_prepare( pstmt);
		close_result(resultset);
	}
	
	public static  void close_connection(Connection conn){
		if(conn !=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		}
 
 public static void close_prepare(PreparedStatement pstmt){
	 if( pstmt !=null){
			try {
				 pstmt.close();
				 pstmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
 }
	 public static void close_result(ResultSet resultset){
		 if(resultset !=null){
				try {
					resultset.close();
					resultset=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} 
        }
}
