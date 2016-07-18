package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import com.database.DataBaseManager;

public class Info_DAO {
	@SuppressWarnings("rawtypes")
	public  Map<String,Vector> authenticate_jtable(){
		 Map<String,Vector> map1=null;		
		 try {
			
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT Kot_no,item_code,item_name,price,quantity,total_price,vat FROM hotel_management.kitchen_order_ticket");
		    ResultSet result=prepare.executeQuery();
		   
		   Vector<String> column_name1=new Vector<String>();
	       Vector<String> current_row1=null;
	       Vector<Vector<String>> data_set1=new Vector<Vector<String>>();
	     
		   while(result.next()) 
		  {     
			   
			    current_row1=new Vector<String>();
	        	ResultSetMetaData rsmd1=result.getMetaData();
	        	
	        	for(int i=1;i<rsmd1.getColumnCount();i++){
	        	    
	        		current_row1.addElement(result.getString(i));
	        	}
	        	data_set1.add(current_row1);
	        	
	        }	
		   
		   column_name1.add(0, "KOT NO");
		   column_name1.add(1, "ITEM CODE");
		   column_name1.add(2, "ITEM NAME");
		   column_name1.add(3, "PRICE(QTY=1)");
		   column_name1.add(4, "QTY");
		   column_name1.add(5,"TOTAL_PRICE");
		   
		   	map1=new HashMap<String,Vector>();
	        map1.put("header_set1", column_name1);
	        map1.put("dataset1",data_set1);   
	       
		 }
		  
		 catch (SQLException  e) {
			e.printStackTrace();
		}
		return map1;
		
}
	
}
