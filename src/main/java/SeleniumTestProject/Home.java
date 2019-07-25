/**
 * 
 */
package SeleniumTestProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author deepa
 *
 */
public class Home {
	
	WebDriver driver;
	
	@FindBy(className="ac-gn-link-iphone")
	public WebElement classNameEle;
	
	
	public Home(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fnClickLink(){
		classNameEle.click();
	}
	
	

}
