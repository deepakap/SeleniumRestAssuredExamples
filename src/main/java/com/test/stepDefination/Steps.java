package com.test.stepDefination;

import org.testng.Assert;

import com.app.test.BaseClass;
import com.app.test.Page;

import org.junit.runner.RunWith;		
import cucumber.api.CucumberOptions;		
import cucumber.api.junit.Cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class Steps extends BaseClass {
	
	Page pageObj;
	 String endPoint = "https://yfs5y.codesandbox.io";
	 
  @Given("^Open the Chrome browser and launch the application$")
  public void Open_the_Chrome_browser_and_launch_the_application() throws Throwable {
	  driver.get(endPoint);
	  Assert.assertEquals(driver.getTitle(), "Sandbox - CodeSandbox");
  }

  @When("^you are in When annotation$")
  public void when() throws Throwable {
  }

  @Then("^you are in Then annotation$")
  public void then() throws Throwable {
  }

}
