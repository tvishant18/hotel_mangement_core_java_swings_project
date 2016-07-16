package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBaseManager;

public class Update_generate_kot_Table_DAO {
	public static ResultSet result;
	public static  List<Integer> mylist;
	
	 public boolean authenticate_table_no(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM hotel_management.table_info where Availiability= ? ");
		     prepare.setString(1, "N");
		//   prepare.setString(2, "R");
		  ResultSet result=prepare.executeQuery();
		  mylist=new ArrayList<>();
		  
		  while(result.next()){
			   isvalid=true;
		  mylist.add(result.getInt(1));
		  
		   }
	
		  
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
	
}
