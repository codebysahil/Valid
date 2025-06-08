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
	
	
	public WebDriver launchBrowser(Properties prop) {
		
		String bname = prop.getProperty("browser");
		om= new OptionsManager(prop);
		
		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(om.getChromeOptions());
		}
		else if (bname.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver(om.getFirefoxOptions());
		}
		
		
		driver.get("https://www.validaide.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
	
	
	public Properties initProperties() {
		prop = new Properties();
		try {
			FileInputStream fp = new FileInputStream("./src/test/resource/config/config.properties");
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
