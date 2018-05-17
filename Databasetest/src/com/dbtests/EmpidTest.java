package com.dbtests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmpidTest
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException 
	{
		
		String dburl,uid,pwd;
		dburl="jdbc:mysql://qedgetech.com:3306/orange123";
		uid="qedgehrm";
		pwd="12345";		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection dbcon;
		dbcon=DriverManager.getConnection(dburl, uid, pwd);		
		Statement stmt=dbcon.createStatement();
		ResultSet rs=stmt.executeQuery
				         ("Select max(emp_number) from hs_hr_employee");
		rs.next();
		int expempno=rs.getInt(1)+1;		
		rs.close();
		dbcon.close();
		
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://orangehrm.qedgetech.com");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Admin");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("PIM")).click();
		driver.findElement(By.linkText("Add Employee")).click();		
		String temp=driver.findElement(By.id("employeeId"))
												.getAttribute("value");
		int actempno=Integer.parseInt(temp);
		System.out.println(expempno);
		System.out.println(actempno);
		if (expempno==actempno) 
		{
			System.out.println("Test Pass");			
		}else
		{
			System.out.println("Test Fail");
		}
		
		
	}

}
