package validaide.qa.website.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	
	
private WebDriver driver;

By emailInput = By.id("email");
By passwordInput = By.id("password");
By loginButtonAlt = By.cssSelector("button[type='submit']");
By forgotPasswordLink = By.linkText("Forgot your password?");
// By errorMessage = By.className("Wrong email or password.");


public LoginPage(WebDriver driver) {
	
	this.driver=driver;
	
}

public void doLogin(String email, String password) {
	
	System.out.println("app credentials " + email + password);
	driver.findElement(passwordInput).sendKeys(password);
	driver.findElement(emailInput).sendKeys(email);
	driver.findElement(loginButtonAlt).click();
	
	// This function will return something and on click it will land to another page.\
	// This is called page chaining.
	
	
	
	
	
}



}
