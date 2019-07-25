/**
 * 
 */
package SeleniumTestProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author deepa
 *
 */
public class Ipad {
	
	
	WebDriver driver;
	
	@FindBy(className="chapternav-link")
	List<WebElement> lnkList;
	
	public Ipad(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void iPadLinkisDisplayed(){
		Assert.assertEquals(lnkList.get(4).isDisplayed(), true, "Issue : iPad compare link is not displayed !");
	}
	
	public void clickLink(){
		
		System.out.print(" > "+lnkList.size());
		lnkList.get(4).click();
	}
	
	

}
