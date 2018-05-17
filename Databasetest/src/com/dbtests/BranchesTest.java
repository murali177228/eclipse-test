package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BranchesTest {

	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		
		String dburl,uid,pwd;
		dburl="jdbc:sqlserver://primusbank.qedgetech.com:1433;database=bankdb";
		uid="qedge";
		pwd="qedge";
		
		Connection dbconn=DriverManager.getConnection(dburl, uid, pwd);
		
		Statement stmt=dbconn.createStatement();
		ResultSet rs=stmt.executeQuery("select branchid,branchname from bankbranches order by branchid");
		
		while(rs.next())
		{
			int id=rs.getInt("branchid");
			String name=rs.getString("branchname");
			System.out.println(id+ " "+name);
			
		}
		
		rs.close();
		dbconn.close();

	}

}
