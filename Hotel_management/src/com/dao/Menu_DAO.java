package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.BO.Menu_info;
import com.database.DataBaseManager;

public class Menu_DAO {
	 public boolean authenticate_menu(Menu_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("INSERT INTO `hotel_management`.`menu` (`item_code`, `item`, `dept`, `price(in RS)`, `VAT`, `total_price`) VALUES (?, ?, ?, ?, ?,?);");
		   prepare.setString(1, info.getItem_code());
		   prepare.setString(2,info.getItem());
		   prepare.setString(3, info.getDepartment());
		   prepare.setFloat(4, info.getPrice());
		  
		   prepare.setFloat(5, info.getVAT());
		   prepare.setFloat(6,info.getTotal_price());
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