package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.BO.Table_info;
import com.database.DataBaseManager;

public class Add_table_DAO {
	public boolean authenticate_new_table(Table_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("UPDATE `hotel_management`.`table_info` SET `guest_name`=?, `pax`=?,`Availiability`=?, `Date_time`=?, `Steward_id`=?, `Steward_name`=? WHERE `table_no`= ?");
		   prepare.setString(1, info.getGuest_name());
		   prepare.setInt(2, info.getPax());
		   prepare.setString(3,"N");
		   prepare.setString(4, info.getDate());
		   prepare.setInt(5, info.getSteward_id());
		   prepare.setString(6, info.getSteward_name());
		   prepare.setInt(7, info.getTable_no());
		   int execute=prepare.executeUpdate();
		   if(execute>0){
			   isvalid=true;
			}
		   DataBaseManager.close_prepare(prepare);
		   DataBaseManager.close_connection(connection);
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isvalid;
	}
}
