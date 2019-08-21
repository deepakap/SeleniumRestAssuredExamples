package com.app.test;
 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ChromeDriver driver;
	
	@BeforeSuite
	public void setUpChromeDriver(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	
	@AfterSuite
	public void closeBrowser(){
		driver.close();
	}
	
	

}
