package com.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.database.DataBaseManager;

public class Auto_generate_KOT_no_DAO {
	public static int KOT_NO;
	public static int BILL_NO;
	public boolean authenticate_table_no(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT max(kot_no +1) FROM hotel_management.kitchen_order_ticket ");
		    ResultSet result=prepare.executeQuery();
	    
		  if(result.next()){
			   isvalid=true;
			   KOT_NO=result.getInt(1);
		   }
	 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}

	
	public boolean authenticate_bill_no(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT max(bill_no +1) FROM hotel_management.bill_info ");
		    ResultSet result=prepare.executeQuery();
	    
		  if(result.next()){
			   isvalid=true;
			   BILL_NO=result.getInt(1);
		   }
	 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
}
