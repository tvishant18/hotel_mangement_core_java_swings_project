package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BO.Master_info;

import com.database.DataBaseManager;

public class Change_password_DAO {
	 public boolean authenticate_change_password(Master_info info){
		  boolean isvalid=false;
		  try {
		  Connection connnection=DataBaseManager.getconnection();
		  PreparedStatement prepare=connnection.prepareStatement("SELECT * FROM hotel_management.master_info_table where master_name=? and secret_ques=? and secret_ans=?");
		  prepare.setString(1,info.getUsername() );
		  prepare.setString(2, info.getSecret_question());
		  prepare.setString(3, info.getSecret_answer());
		  ResultSet result=prepare.executeQuery();
		  while(result.next()){
			  isvalid=true;
		  }
		  DataBaseManager.close_all_connection(connnection, prepare, result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isvalid;
		  
	  }
	  
}
