package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.BO.Menu_info;
import com.database.DataBaseManager;

public class Update_menu_DAO {
	public boolean authenticate_update_item(Menu_info info2){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("UPDATE `hotel_management`.`menu` SET  `item`=?, `dept`=?, `price(in RS)`=?, `VAT`=?, `total_price`=? WHERE `item_code`=?");
		   prepare.setString(1, info2.getItem());
		   prepare.setString(2, info2.getDepartment());
		   prepare.setFloat(3, info2.getPrice());
		   prepare.setFloat(4, info2.getVAT());
		   prepare.setFloat(5, info2.getTotal_price());
		   prepare.setString(6, info2.getItem_code());
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
