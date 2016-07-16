package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BO.KOT_info;
import com.database.DataBaseManager;

public class Update_combo_add_item_name_DAO {
	public static ResultSet result;
	public boolean authenticate_item(KOT_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM `hotel_management`.`menu` where item =? ");
		   prepare.setString(1,info.getItem_name() );
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
