package com.DAO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.database.DataBaseManager;

public class Update_combo_DAO {
	public static ResultSet result;
	public static  List<String> mylist;
	public static List<String>  mylist1;
	 public boolean authenticate_item(){
		 boolean isvalid=false;
		 try {
		   Connection connection=DataBaseManager.getconnection();
		   PreparedStatement prepare=connection.prepareStatement("SELECT * FROM `hotel_management`.`menu` ");
		  ResultSet result=prepare.executeQuery();
		  mylist=new ArrayList<>();
		  mylist1=new ArrayList<>();
		  while(result.next()){
			   isvalid=true;
		  mylist.add(result.getString(1));
		  mylist1.add(result.getString(2));
		   }
	//	 String a[]=new String[mylist.size()];
		//  a=mylist.toArray(a);
		  //String d[]=mylist.toArray(new String[mylist.size()]);
		//  for(String s : mylist){
		//	  System.out.println(s);
		//  }
		  
		
		 } catch (SQLException e) {
			
			e.printStackTrace();
		}
	return isvalid;
}
	
}
