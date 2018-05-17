package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLServerDBTest
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
	
		
	//Step 1: Connecting to DataBase
		
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
	 												.newInstance();
	 String dburl,uid,pwd;
	 dburl="jdbc:sqlserver://primusbank.qedgetech.com:1433;" +
	 											"database=bankdb";
	 uid="qedge";
	 pwd="qedge";	 
	 Connection dbcon;
	 dbcon=DriverManager.getConnection(dburl, uid, pwd);
		
	 //Step 2: Send SQL commands to DataBase	 
	 Statement stmt=dbcon.createStatement();
	 ResultSet rs=stmt.executeQuery
			               ("select count(*) from bankbranches");
	 //Step 3: Process Results
	 rs.next();
	 int brcount=rs.getInt(1);
	 System.out.println(brcount);
	 
	 rs.close();
	 dbcon.close();
	 
	 
	 
	 
	 
	 
	}

}
