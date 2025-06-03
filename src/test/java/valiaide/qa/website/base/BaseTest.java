package valiaide.qa.website.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import validaide.qa.website.factory.DriverFactory;
import validaide.qa.website.pages.HomePage;

public class BaseTest {
	
	public WebDriver driver;
	public Properties prop;
	public DriverFactory df;
	public HomePage homePage;
	
	
	@BeforeTest
	public void setup() throws InterruptedException {
		
		df = new DriverFactory();
		df.initprop();
		String browserName =prop.getProperty("browser");

		driver =df.initDriver("browserName");
		homePage = new HomePage(driver);
		
	}
	
//	@AfterTest
	//public void tearDown() {
		//driver.quit();
	//}

}
