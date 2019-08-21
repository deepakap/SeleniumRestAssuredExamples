package com.app.test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class NewTest extends BaseClass {
	
	Page pageObj;
 String endPoint = "https://yfs5y.codesandbox.io";
  @Test(priority=0)
  public void _testLaunchApp() {
	  driver.get(endPoint);
	  Assert.assertEquals(driver.getTitle(), "Sandbox - CodeSandbox");
  }
  
  @Test(priority=1)
  public void _testSelectDropDown() {
//	  WebElement dropDownEle = driver.findElement(By.className("css-1492t68"));
//	  WebDriverWait wait = new WebDriverWait(driver, 20);
//	  wait.until(ExpectedConditions.visibilityOf(dropDownEle));
//	  dropDownEle.click();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  pageObj = new Page(driver);
	  pageObj.enterDropDownText("wuben");
  }
  
  
  @Test(priority=2)
  public void _testSelectDropDownOption(){
	  pageObj.fnSelectDesiredOption(1);
  }
  
  @Test(priority=3)
  public void _testSelectArmorBloxDropDown() {
	  pageObj = new Page(driver);
	  pageObj.enterDropDownText("armorblox");
	  pageObj.fnSelectDesiredOption(0);
  }
  
  @Test(priority=4)
  public void _testClickSubmitBtn() {
	  pageObj.clickOnSubmit();
  }
  
  @Test(priority=4)
  public void _testValidateResultText() {
	  List<String> data = new LinkedList<String>();
	  data.add("wubenhe");
	  data.add("armorblox");
	  pageObj.validateSelectedOptions(data);;
  }
  
  
   
}
