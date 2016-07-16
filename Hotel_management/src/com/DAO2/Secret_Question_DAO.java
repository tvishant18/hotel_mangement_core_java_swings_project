package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BO.Master_info;
import com.database.DataBaseManager;

public class Secret_Question_DAO {
	public  static String Question;
	   public  boolean authenticate_secret_question(Master_info info){
		   boolean isvalid=false;
		   try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("SELECT * FROM hotel_management.master_info_table where master_name=?");
	        prepare.setString(1, info.getUsername());
	        ResultSet result1=prepare.executeQuery();
	        while(result1.next()){
	        	
	        	isvalid=true;
	        	Question=result1.getString(3);
	        	
	        }
	        DataBaseManager.close_all_connection(connection, prepare, result1);
		   } catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
		
	   }
	
	
	
	
}
