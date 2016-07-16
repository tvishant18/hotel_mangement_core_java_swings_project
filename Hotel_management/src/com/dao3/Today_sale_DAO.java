package com.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.BO.Bill_info;
import com.database.DataBaseManager;

public class Today_sale_DAO {
	public static float Total_RES_SALE =0;
	public static float Total_BAR_SALE =0;
	public  boolean authenticate_jtable_R(Bill_info info2){
		boolean isvalid=true;
		 try {
			
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT total_price FROM hotel_management.bill_info where date=? and department=?");
		   prepare.setString(1,info2.getDate());
		   prepare.setString(2,"R");
		   
		   ResultSet result=prepare.executeQuery();
		 float sum=0;
		   while(result.next()){
			   sum=sum+result.getFloat(1); 
		   }
		   Today_sale_DAO.Total_RES_SALE=0;
		   Today_sale_DAO.Total_RES_SALE=sum;
		  DataBaseManager.close_all_connection(connection, prepare, result); 
		 }
		  
		 catch (SQLException  e) {
			e.printStackTrace();
		}
		return isvalid;
		
}
	public  boolean authenticate_jtable_B(Bill_info info2){
		boolean isvalid=true;
		 try {
			
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT total_price FROM hotel_management.bill_info where date=? and department=?");
		   prepare.setString(1,info2.getDate());
		   prepare.setString(2,"B");
		   
		   ResultSet result=prepare.executeQuery();
		   float sum1=0;
		   while(result.next()){
			   sum1=sum1+result.getFloat(1); 
		   }
		   Today_sale_DAO.Total_BAR_SALE=0;
		   Today_sale_DAO.Total_BAR_SALE=sum1;
		  DataBaseManager.close_all_connection(connection, prepare, result); 
		 }
		  
		 catch (SQLException  e) {
			e.printStackTrace();
		}
		return isvalid;
		
}
}
