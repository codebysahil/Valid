package factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager om;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	
	public WebDriver launchBrowser(Properties prop, String url) {
		
		String bname = prop.getProperty("browser");
		om= new OptionsManager(prop);
		
		if(bname.equalsIgnoreCase("chrome")) {
			// driver = new ChromeDriver(om.getChromeOptions());
			tlDriver.set(new ChromeDriver(om.getChromeOptions()));
		}
		else if (bname.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver(om.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(om.getFirefoxOptions()));
		}
		
		
		
		
		//driver.get("https://www.validaide.com/");
		getDriver().get(prop.getProperty(url));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver();
		
		
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties initProperties() {
		prop = new Properties();
		FileInputStream fp =null;
		// command line arguments with the help of maven
		try {
			fp = new FileInputStream("./src/test/resource/config/config.properties");
			try {
				prop.load(fp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		
	}

}
