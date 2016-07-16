package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BO.Master_info;
import com.database.DataBaseManager;

public class Sign_in_DAO {
	public boolean authenticate_master(Master_info info) throws SQLException{
		boolean isvalid=false;
		try {
			Connection connection=DataBaseManager.getconnection();
			PreparedStatement prepare=connection.prepareStatement("select * from hotel_management.master_info_table where master_name=? and master_password=?");
			prepare.setString(1,info.getUsername());
			prepare.setString(2, info.getPassword());
		    ResultSet result2=prepare.executeQuery();
			while(result2.next()){
				isvalid=true;
			}
			DataBaseManager.close_all_connection(connection, prepare, result2);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return isvalid;
		
	}		

}
