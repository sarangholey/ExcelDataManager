package com.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hubspot 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/login");
		
	}
	
	@Test(dataProvider = "userdata")
	public void test(String email,String password)
	{
		WebElement emailID = driver.findElement(By.xpath("//input[@id='username']"));
		emailID.sendKeys(email);
		
		WebElement Password = driver.findElement(By.xpath("//input[@id='password']"));
		Password.sendKeys(password);
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider(name = "userdata")
	public Object testData()
	{
		Object contactData = ExcelUtil.excelDataProvider();
		return contactData;
	}
}
