package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BO.Menu_info;
import com.database.DataBaseManager;

public class Update_combo_item_name {
public static ResultSet result;
	public boolean authenticate_item(Menu_info info1){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM `hotel_management`.`menu` where item_code=? ");
		   prepare.setString(1, info1.getItem_code());
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
