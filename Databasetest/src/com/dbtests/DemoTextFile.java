package com.dbtests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoTextFile
{

	public static void main(String[] args) throws IOException 
	{
	
		FileReader fr=new FileReader("d:\\HomePagecontent.txt");
		BufferedReader br=new BufferedReader(fr);
		String expdata;
		expdata=br.readLine();
		
		WebDriver driver=new FirefoxDriver();
		driver.get("http://primusbank.qedgetech.com");
String actdata=driver.findElement
			(By.xpath("//table/tbody/tr[2]/td[1]/p[1]")).getText();
		if (expdata.equalsIgnoreCase(actdata)) 
		{
			System.out.println("Test Pass");	
		} else 
		{
			System.out.println("Test Fail");
		}

	}

}
