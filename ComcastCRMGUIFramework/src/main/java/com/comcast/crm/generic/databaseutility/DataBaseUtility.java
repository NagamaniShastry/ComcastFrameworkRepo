package com.comcast.crm.generic.databaseutility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection conn;
	
	 public void getDBConnection() throws SQLException 
	 {
		try 
		{ 
	    Driver driver= new Driver();
	    DriverManager.registerDriver(driver);
	    conn = DriverManager.getConnection("jdbc:mysql://localhost:/3306/projects", "root", "root");
		}
	    catch(Exception e)
		{
		
		}
	    
	 }
	 
	 public void getCloseDBConnection() throws SQLException 
	 {
		try
		{
	   conn.close();
		}
		catch(Exception e)
		{
			
		}
	 }
	 
	 public ResultSet executeSelectquery(String query) throws SQLException
	 {   
		 ResultSet resultSet=null;
		  
		try
		{
	     Statement stat = conn.createStatement();
	     resultSet = stat.executeQuery(query);		 
		
	   }
	  catch(Exception e)
		{}
		
		 return resultSet; 	 
	 }
	 
	 
	 public int executeNonSelectquery(String query) throws SQLException
	 {
		 int resultset=0;
		 try
		 {
		  Statement stmt = conn.createStatement();		 
		  resultset = stmt.executeUpdate(query);
		 }
		 
		 catch(Exception e)
		 {
			 
		 }
		 
		 return resultset;
	 }
	 
	 
}
