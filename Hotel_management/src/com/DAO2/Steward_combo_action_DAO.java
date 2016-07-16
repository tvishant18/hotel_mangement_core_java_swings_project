package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BO.Staff_info;
import com.database.DataBaseManager;

public class Steward_combo_action_DAO {
	public static ResultSet result;
	public boolean authenticate_steward_id_combo(Staff_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM hotel_management.steward_boy_details where steward_id=?");
		   prepare.setInt(1,info.getSteward_id() );
		   result=prepare.executeQuery();
		
		  if(result.next()){
			   isvalid=true;
		 }
	} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
}
