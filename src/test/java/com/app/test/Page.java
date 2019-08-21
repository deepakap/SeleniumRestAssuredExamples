/**
 * 
 */
package com.app.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author deepa
 *
 */
public class Page {
	
	WebDriver driver;
	
	@FindBy(className="select__input")
	public WebElement dropDown;
	
	@FindBy(id="react-select-2-input")
	public WebElement dropDownInput;
	
	@FindBy(tagName="button")
	public WebElement submitButton;
	
	@FindBy(className="select__option")
	public List<WebElement> selectOptions;
	
	
	@FindBy(tagName="li")
	public List<WebElement> dropDownOptions;
	
	@FindBy(tagName="h3")
	public List<WebElement> h3TagElements;
	
	
	public Page(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void fnPressTab(){
//		Actions action = new Actions(driver);
//		action.contextClick().keyUp(Keyboard)
//		
//	}
	
	
	public void enterDropDownText(String str){
		dropDownInput.sendKeys(str);
		//dropDownInput.sendKeys(Keys.TAB);
		//dropDownInput.sendKeys(Keys.ENTER);
	}
	
	public void fnSelectDesiredOption(int optionNumber){
		System.out.println(" count of drop down options are :"+selectOptions.size());
		for(WebElement ob:selectOptions){
			System.out.println(" >>>>>>>>> "+ob.getText());
			
		}
		selectOptions.get(optionNumber).click();
	}
	
	public void clickOnSubmit(){
		submitButton.click();
	}
	
	
	public void validateSelectedOptions(List<String> data){
		LinkedList<String> results = new LinkedList<String>();
		for(WebElement st: h3TagElements){
			results.add(st.getText());
		}
		Assert.assertEquals(results, data, "info data does not match");
		
	}

}
