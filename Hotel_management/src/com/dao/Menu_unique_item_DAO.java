package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.BO.Menu_info;
import com.database.DataBaseManager;


public class Menu_unique_item_DAO {
	 public boolean authenticate_item(Menu_info info){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM `hotel_management`.`menu` WHERE item_code=? and item=?");
		   prepare.setString(1, info.getItem_code());
		   prepare.setString(2,info.getItem());
		   ResultSet result=prepare.executeQuery();
		   if(result.next()){
			   isvalid=false;
		   }
		   else{
			   isvalid=true;
		   }
		   DataBaseManager.close_prepare(prepare);
		   DataBaseManager.close_connection(connection);
		 } catch (SQLException |NumberFormatException e) {
			 JOptionPane.showMessageDialog(null, "Please fill the price ,vat and Total price field ");
			e.printStackTrace();
		}
		return isvalid;
}
}
