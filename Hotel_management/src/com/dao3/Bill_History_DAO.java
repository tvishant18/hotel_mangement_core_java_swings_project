package com.dao3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import com.BO.Bill_info;
import com.database.DataBaseManager;

public class Bill_History_DAO {
	@SuppressWarnings("rawtypes")
	public  Map<String,Vector> authenticate_jtable(Bill_info info1){
		 Map<String,Vector> map1=null;		
		 try {
			
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT bill_no,date,table_no,guest_name,discount,service_tax,total_after_discount,total_price FROM hotel_management.bill_info where date=?");
		   prepare.setString(1,info1.getDate());
		 //  prepare.setString(1,"15/07/2016");
		   
		   ResultSet result=prepare.executeQuery();
		   
		   Vector<String> column_name1=new Vector<String>();
	       Vector<String> current_row1=null;
	       Vector<Vector<String>> data_set1=new Vector<Vector<String>>();
	     //  boolean header_set=true;
		   while(result.next()) 
		  {
			    current_row1=new Vector<String>();
	        	ResultSetMetaData rsmd1=result.getMetaData();
	        	for(int i=1;i<=rsmd1.getColumnCount();i++){
	        	
	        		current_row1.addElement(result.getString(i));
	        	}
	        	data_set1.add(current_row1);
	        	//header_set=false;
	        }	
		   column_name1.add(0, "BILL NO");
		   column_name1.add(1, "DATE");
		   column_name1.add(2, "TABLE NO");
		   column_name1.add(3, "GUEST NAME");
		   column_name1.add(4,"DISCOUNT");
		   column_name1.add(5,"SERVICE TAX");
		   column_name1.add(6, "AMOUNT AFTER DISCOUNT");
		   column_name1.add(7, "TOTAL AMOUNT");
		   
		   	map1=new HashMap<String,Vector>();
	        map1.put("header_set1", column_name1);
	        map1.put("dataset1",data_set1);   
	        DataBaseManager.close_all_connection(connection, prepare, result); 
		 }
		  
		 catch (SQLException  e) {
			e.printStackTrace();
		}
		return map1;
		
}

}
