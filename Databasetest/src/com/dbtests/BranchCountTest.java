package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BranchCountTest
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		 String server = "localhost";
         String database = "master";
         String password = "sapassword";

         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         String connectionUrl = "jdbc:sqlserver://"+server+":1433;databaseName="+database+";user=sa;password="+password+";";
         Connection con = (Connection) DriverManager.getConnection(connectionUrl);
		//Connection dbcon = DriverManager.getConnection(dburl, uid, pwd);
		Statement stmt = con.createStatement();
		ResultSet rs= stmt.executeQuery("select count(*) from bankbranches");
		rs.next();
		int expcount = rs.getInt(1);
		rs.close();
		con.close();		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com");
		WebElement blistelement;
		blistelement = driver.findElement(By.id("drlist"));
		Select brlist = new Select(blistelement);
		List<WebElement> branchlist= brlist.getOptions();
		int actcount = branchlist.size()-1;
		if(actcount == expcount)
		{
			System.out.println("Test pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
