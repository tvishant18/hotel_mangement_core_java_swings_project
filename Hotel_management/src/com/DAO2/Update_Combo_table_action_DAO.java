package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.BO.Table_info;
import com.database.DataBaseManager;

public class Update_Combo_table_action_DAO {
	
		public static ResultSet result;
	
		public boolean authenticate_table_no(Table_info info){
			 boolean isvalid=false;
			 try {
			   Connection connection=DataBaseManager.getconnection();
			   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM hotel_management.table_info where table_no= ? ");
			   prepare.setInt(1, info.getTable_no());
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
