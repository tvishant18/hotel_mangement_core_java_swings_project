package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.database.DataBaseManager;

public class Update_bar_steward_id_combo_DAO {
	public static ResultSet result;
	public static  List<Integer> mylist1;
	
	 public boolean authenticate_steward_id(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM hotel_management.steward_boy_details where department=?");
		   prepare.setString(1, "B");
		  ResultSet result=prepare.executeQuery();
		  mylist1=new ArrayList<>();
		  
		  while(result.next()){
			   isvalid=true;
		  mylist1.add(result.getInt(1));
		  
		   }
	
		  
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
	
}
