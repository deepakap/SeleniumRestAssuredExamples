/**
 * 
 */
package SeleniumTestProject;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.org.common.Home;
import com.org.common.Ipad;

import SeleniumTestProject.*;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author deepa
 *
 */
public class ValidateLoginPage {
	
	WebDriver driver;
	String url = "https://www.apple.com/";
	Ipad pad;

	@BeforeClass
	public void fnSetDeriver(){
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "/Users/deepa/Documents/workspace/SeleniumTestProject/Drivers/chromedriver");	
		ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		driver = new ChromeDriver(options);
	}
	
	@Test(enabled=true, priority=0)
		public void fnApplication(){
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void fnValidateTitle(){
		Assert.assertEquals(driver.getTitle().toString(), "Apple");
	}
	
	
	
	@Test(priority=2)
	public void fnClickWebELe(){
		
		Home hme = new Home(driver);
		hme.fnClickLink();
		
		
		
		
	}
	
	
//	@Test(priority=2)
//	public void fnClickWebEle(){
//		
//		WebElement ele = driver.findElement(By.className("ac-gn-link-iphone"));
//		WebDriverWait wait = new WebDriverWait(driver, 50000);
//		wait.until(ExpectedConditions.visibilityOf(ele));
//		
//		Assert.assertEquals(ele.isDisplayed(), true, "Element not visible !");
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		
//		ele.click();
//	}
	
	
	
	
	
	@Test(priority=3)
	public void listAllItems(){
		ArrayList<WebElement> elist = (ArrayList<WebElement>) driver.findElements(By.className("chapternav-item"));
		for(WebElement wb:elist){
			System.out.print(" ele "+wb.getText());
		}
	}
	
	
	@Test(priority=4)
	public void fnPerformActions(){
		pad = new Ipad(driver);
		pad.iPadLinkisDisplayed();
		
		
//		WebElement ele =  driver.findElements(By.className("chapternav-label")).get(4);
//		Actions actions = new Actions(driver);
//		actions.click(ele).perform();
	}
	
	
	@Test(priority=5)
	public void fnclickCompareLink(){
		pad.clickLink();
	}
	
	
	
	@Test(priority=6)
	public void scrollToElement(){
		
		WebElement lnk = driver.findElement(By.linkText("Find an Apple Store"));
		Actions acn = new Actions(driver);
		acn.moveToElement(lnk);
	}
	
	@Test(priority=7)
	public void veryAndClick(){
		WebElement lnk = driver.findElement(By.linkText("Find an Apple Store"));

		Assert.assertEquals(lnk.isDisplayed(), true, "Issue : Link is not displayed !");
		Assert.assertEquals(lnk.isEnabled(), true, "Issue : Link is not enabled  !");

		lnk.click();
	}
	
	
	
	
	@AfterClass
	public void fnTerminateDriver(){
		driver.close();
	}
	
	
	
	
}
