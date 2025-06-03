package validaide.qa.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver; // private -- scope of this reference variable is only this class
	
	// 1. By Locators --Object Repository
	
	// using the concepts of encapsulation, keeping all the by locators as private
	// all the by locators will be private and we will use the public page actions 
	
	private By loginButton= By.linkText("Login");
	// private By freeTrialButton = By.xpath("\"//a[contains(text(), 'Start Your Free Trial')]\"");
	private By validaideLogo = By.cssSelector("img[alt='Validaide logo']");
	private By aboutusLink = By.linkText("About Us");
	private By careersLink = By.linkText("Careers");
	private By freeTrialButton = By.cssSelector("span.l7_2fn.wixui-button__label");

	
	// 2 Page class constructor -- Public and to get the driver
	// in constructor no business logic
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	
	// Page Actions
	
	public String getHomePageTitle() {
		System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	public String getHomePageUrl() {
		// driver.getCurrentUrl();
		return driver.getCurrentUrl();
		
	}
	
	public boolean isCareerLinkExist() {
		return driver.findElement(careersLink).isDisplayed(); // encapsulation private members accessed by public methods
		
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(validaideLogo).isDisplayed();
	}
	
	
	public boolean isFreeTrialDisplayed() {
		return driver.findElement(freeTrialButton).isDisplayed();
	}
	
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
		// This will return something and will take to next page.
	}
	
	public boolean isLoginButtonDisplayed() {
		return driver.findElement(loginButton).isDisplayed();
	}
	
	
	public void clickStartFreeTrialButton(){
		driver.findElement(freeTrialButton).click();
		
		
	}
	
	public boolean isClickStartFreeTrialButtonVisible() {
		return driver.findElement(freeTrialButton).isDisplayed();
	}
	
	
	
	
	
	
	
	

}
