package com.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.BO.KOT_info;
import com.database.DataBaseManager;

public class Insertion_KOT_no_DAO {
	 public boolean authenticate_kot(KOT_info info5){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `hotel_management`.`kitchen_order_ticket` (`kot_no`, `table_no`, `item_code`, `item_name`, `quantity`, `price`, `date`, `Department`, `steward_id`, `steward_name`, `vat`, `total_price`, `total_cost`, `s_no`) VALUES (?, '1', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', ?)");
		   prepare.setInt(1,info5.getKOT_no());
		   prepare.setInt(2, info5.getSr_no());
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
	 public boolean authenticate_auto_kot(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("DELETE FROM `hotel_management`.`kitchen_order_ticket` WHERE price=? ");
		   prepare.setInt(1,0);
		 
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

