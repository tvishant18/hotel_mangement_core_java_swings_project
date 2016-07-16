package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BO.Bill_info;
import com.database.DataBaseManager;

public class Bill_Amount_DAO {
	public static float Amount_AFTER_DISCOUNT=0;
	public static float TOTAL_AMOUNT=0;
	public static float EXTRA=0;
	public boolean authenticate_cost(Bill_info info){
		boolean isvalid=true;
		int DISCOUNT=info.getDiscount();
		float SERVICE_TAX=info.getService_tax();
		
		
		try {
			Connection connection=DataBaseManager.getconnection();
			   PreparedStatement prepare=connection.prepareStatement("SELECT item_code,item_name,price,quantity,total_price,vat FROM hotel_management.kot_record where table_no=? ");
			   prepare.setInt(1, info.getTable_no());
			 
			  ResultSet result=prepare.executeQuery();
			   
			
			
			
			float sum1=0;
			float sum2=0;
			while(result.next()){
				
				System.out.println(result.getFloat(5));
				float value=(result.getFloat(5)-((result.getFloat(5) * DISCOUNT)/100));
				sum1=sum1+ value;
				sum2=sum2 +	(value*(result.getFloat(6)+SERVICE_TAX)/100);		
	       
			} 
			Bill_Amount_DAO.Amount_AFTER_DISCOUNT=0;
			Bill_Amount_DAO.EXTRA=0;
			Bill_Amount_DAO.TOTAL_AMOUNT=0;
			Amount_AFTER_DISCOUNT=sum1;
			EXTRA=sum2;
			TOTAL_AMOUNT=sum1+sum2;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isvalid;
		
	}
}
