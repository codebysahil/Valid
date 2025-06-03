package validaide.qa.website.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import valiaide.qa.website.base.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test
	public void homePageTitleTest() {
		String actualTitle=homePage.getHomePageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle,"Validaide | Supplier Qualification & Lane Risk Assessments | Netherlands");
		
	}
	
	@Test
	public void logoDisplayedTest() {
		boolean islogoDisplayedOnHomePage = homePage.isLogoDisplayed();
		Assert.assertTrue(islogoDisplayedOnHomePage);
	}
	
	@Test
	public void loginButtonDisplayedTest() {
	
		Assert.assertTrue(homePage.isLoginButtonDisplayed());
	}

	
	@Test
	public void freeStartTrialButtonDisplayedTest() {
		Assert.assertTrue(homePage.isClickStartFreeTrialButtonVisible());
		
	}
	
	@Test
	
	public void clickLoginButtonTest() {
		homePage.clickLogin();
	}
	@Test(priority=1)
	public void clickStartFreeTrialButtonTest() {
		homePage.clickStartFreeTrialButton();
	}
	
}
