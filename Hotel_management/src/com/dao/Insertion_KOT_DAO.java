package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.BO.KOT_info;
import com.database.DataBaseManager;

public class Insertion_KOT_DAO {
	 public boolean authenticate_kot(KOT_info info1){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("UPDATE `hotel_management`.`kitchen_order_ticket` SET `table_no`=?, `item_code`=?, `item_name`=?, `quantity`=?, `price`=?, `date`=?, `Department`=?, `steward_id`=?, `steward_name`=?, `vat`=?, `total_price`=?, `total_cost`=? WHERE  kot_no=? and s_no=?");
		   prepare.setInt(1, info1.getTable_no());
		   prepare.setString(2, info1.getItem_code());
		   prepare.setString(3,info1.getItem_name());
		   prepare.setFloat(4, info1.getQuantity());
		   prepare.setFloat(5,info1.getPrice());
		   prepare.setString(6,info1.getDate());
		   prepare.setString(7, info1.getDepartment());
		   prepare.setInt(8, info1.getSteward_id());
		   prepare.setString(9, info1.getSteward_name());
		   prepare.setFloat(10, info1.getVat());
		   prepare.setFloat(11, info1.getTotal_price());
		   prepare.setFloat(12,info1.getTotal_cost());
		   prepare.setInt(13,info1.getKOT_no());
		   prepare.setInt(14, info1.getSr_no());
		   int execute=prepare.executeUpdate();
		   if(execute>0){
			   isvalid=true;
			   
		   }
		   DataBaseManager.close_prepare(prepare);
		   DataBaseManager.close_connection(connection);
		 } catch (SQLException | NumberFormatException e) {
			
			e.printStackTrace();
		}
		return isvalid;
}
	 
	 public boolean authenticate_kot_record(KOT_info info1){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `hotel_management`.`kot_record` ( `Kot_no`, `table_no`, `item_code`, `item_name`, `quantity`, `date`, `vat`, `price`, `department`, `steward_id`, `steward_name`,`total_price`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		   prepare.setInt(1, info1.getKOT_no());
		   prepare.setInt(2, info1.getTable_no());
		   prepare.setString(3,info1.getItem_code());
		   prepare.setString(4, info1.getItem_name());
		   prepare.setFloat(5,info1.getQuantity());
		   prepare.setString(6,info1.getDate());
		   prepare.setFloat(7, info1.getVat());
		   prepare.setFloat(8, info1.getPrice());
		   prepare.setString(9, info1.getDepartment());
		   prepare.setInt(10, info1.getSteward_id());
		   prepare.setString(11, info1.getSteward_name());
		   prepare.setFloat(12, info1.getTotal_price());
		   int execute=prepare.executeUpdate();
		   if(execute>0){
			   isvalid=true;
			   
		   }
		   DataBaseManager.close_prepare(prepare);
		   DataBaseManager.close_connection(connection);
		 } catch (SQLException | NumberFormatException e) {
			
			e.printStackTrace();
		}
		return isvalid;
}
}
