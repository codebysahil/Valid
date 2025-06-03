package validaide.qa.website.factory;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop ;
	/**
	 * this method is used to launch the diver on the bases of provided browser name
	 * @param browserName
	 * @return
	 * @throws InterruptedException 
	 */
	
	public WebDriver initDriver(String browserName) throws InterruptedException {
		
		if(browserName.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		else {
			System.out.println("Please pass a correct browser name  "+ " "+ browserName);
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // why this has been added
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(1000);
		return driver;
		
	}
	/**
	 * 
	 * @return this returns properties reference with all configuration properties
	 */
	
	public Properties initprop() {
		
		prop = new Properties(); // to load the properties 
		
		try {
			FileInputStream fp = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fp);// to establish a connection 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
	}
	
	
	
	
	

}
