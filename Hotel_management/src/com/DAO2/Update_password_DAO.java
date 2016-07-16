package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.BO.Master_info;
import com.database.DataBaseManager;

public class Update_password_DAO {
	boolean isvalid=false;
	public boolean authenticate_password(Master_info info1){
		
		if(info1.getNew_password().equals(info1.getRetype_password()))
		try {
			Connection connection = DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("update hotel_management.master_info_table set master_password=? where master_name=?  ");
	        prepare.setString(1,info1.getNew_password());
	        prepare.setString(2,info1.getUsername());
			int execute=prepare.executeUpdate();
	        if(execute > 0){
	        	isvalid=true;
	        }
	    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
 }
}
