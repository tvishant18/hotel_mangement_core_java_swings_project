package com.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.BO.KOT_info;
import com.database.DataBaseManager;

public class Autogenerate_SNO_DAO {
public static int SR_NO;
public static float PRICE;	
	public boolean authenticate_table_no(KOT_info info4){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT max(s_no +1),price  FROM hotel_management.kitchen_order_ticket where kot_no=? ");
		   prepare.setInt(1, info4.getKOT_no());
		   ResultSet result=prepare.executeQuery();
	    
		  if(result.next()){
			   isvalid=true;
			   SR_NO=result.getInt(1);
			   PRICE=result.getFloat(2);
		   }
	 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
	
}
