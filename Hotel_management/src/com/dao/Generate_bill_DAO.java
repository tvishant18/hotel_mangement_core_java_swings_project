package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.BO.Bill_info;
import com.database.DataBaseManager;

public class Generate_bill_DAO {
	public boolean authenticate_new_bill(Bill_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `hotel_management`.`bill_info` (`bill_no`, `table_no`, `department`, `guest_name`, `pax`, `steward_id`, `steward_name`, `date`, `time`, `discount`, `service_tax`, `total_after_discount`, `total_price`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		   prepare.setInt(1, info.getBill_no());
		   prepare.setInt(2, info.getTable_no());
		   prepare.setString(3,info.getDepartment());
		   prepare.setString(4, info.getGuest_name());
		   prepare.setInt(5, info.getPax());
		   prepare.setInt(6, info.getSteward_id());
		   prepare.setString(7, info.getSteward_name());
		   prepare.setString(8, info.getDate());
		   prepare.setString(9, info.getTime());
		   prepare.setInt(10, info.getDiscount());
		   prepare.setFloat(11, info.getService_tax());
		   prepare.setFloat(12, info.getPrice_After_discount());
		   prepare.setFloat(13, info.getTotal_price());
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

	public boolean authenticate_new_table(Bill_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("UPDATE `hotel_management`.`table_info` SET `guest_name`=?, `pax`='0', `Availiability`='Y', `Steward_id`='0', `Steward_name`=?,`Date_time`=? WHERE `table_no`=?");
		   prepare.setString(1, "");
		   prepare.setString(2, "");
		   prepare.setString(3,"");
		   prepare.setInt(4, info.getTable_no());
		   int execute=prepare.executeUpdate();
		   if(execute>0){
			   isvalid=true;
			}
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isvalid;
	}
	public boolean authenticate_kot(Bill_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("DELETE FROM `hotel_management`.`kot_record` WHERE table_no=?");
		   prepare.setInt(1, info.getTable_no());
		   int execute=prepare.executeUpdate();
		   if(execute>0){
			   isvalid=true;
			}
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
		return isvalid;
	}

}
