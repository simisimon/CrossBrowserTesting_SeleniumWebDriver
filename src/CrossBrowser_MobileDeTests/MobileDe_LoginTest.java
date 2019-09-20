package CrossBrowser_MobileDeTests;

import org.testng.annotations.Test;

import CrossBrowser_BrowserSetUp.Browser;
import CrossBrowser_MobileDePageObjects.MobileDe_LoginPage;
import CrossBrowser_MobileDePageObjects.MobileDe_StartPage;

import org.testng.Assert;
import org.testng.Reporter;

public class MobileDe_LoginTest extends MobileDe_Tests { 
	private static final String WARNING_MESSAGE = "Die eingegebene Kombination aus Nutzernamen und Passwort ist nicht korrekt.";
	// Konstanten
	private static final String HEADER_CLAIM = "Deutschlands größter Fahrzeugmarkt";
	private static final String PASSWORD = "123Test456";
	private static final String EMAIL = "Bastisimon95@googlemail.com";
	

	@Test(priority = 0)
	public void verifyStartPage() {
		MobileDe_StartPage start_page = new MobileDe_StartPage(Browser.driver);

		Assert.assertTrue(start_page.isMobileIconDisplayed());
		Reporter.log("Mobile icon is visible");

		Assert.assertTrue(start_page.checkLinksEnabled());
		Reporter.log("Links to start page and login are active");

		Assert.assertEquals(start_page.getHeaderClaim(), HEADER_CLAIM);
		Reporter.log("Header title  verified: " + start_page.getHeaderClaim());

		Assert.assertFalse(start_page.isMyMobileDisplayed());
		Reporter.log("I am not logged in: login button is visible");

	}
	
	@Test(priority = 1)
	public void verifyNegativeLogin() throws InterruptedException {
		MobileDe_LoginPage login_page = new MobileDe_LoginPage(Browser.driver);

		login_page.getLoginURL();
		Reporter.log("Go to the login");

		login_page.loadPage();
		Reporter.log("Load page");
		
		login_page.setEmail(EMAIL);
		login_page.setPassword("test");
		Reporter.log("Parameter passed");
		login_page.submitRegistration();
		Reporter.log("Login confirmed");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(login_page.isWarningMessageDisplayed());
		Reporter.log("Warning message is displayed");
		Assert.assertTrue(login_page.getMessageText().equals(WARNING_MESSAGE));
		Reporter.log("Warning message was compared");
		
		login_page.goBack();
		Reporter.log("Return to last page");
	}

	@Test(priority = 2)
	public void verifyLogin() throws InterruptedException {
		MobileDe_LoginPage login_page = new MobileDe_LoginPage(Browser.driver);

		login_page.getLoginURL();
		Reporter.log("Go to the login");
		login_page.loadPage();
		Reporter.log("Load page");
		login_page.setEmail(EMAIL);
		login_page.setPassword(PASSWORD);
		Reporter.log("Parameter passed");
		login_page.submitRegistration();
		Reporter.log("Login confirmed");
		
		Assert.assertTrue(login_page.isMyMobileDisplayed());
		Reporter.log("Login was successful");

		Thread.sleep(1000);

		login_page.clickMyMobileDe();
		login_page.clickLogOut();
		Reporter.log("Logout confirmed");

		Assert.assertTrue(login_page.isRegistrationDisplayed());
		Reporter.log("Logout was successful");

		// Thread.sleep(3000);
		login_page.loadPage();
		Reporter.log("Wait to start the new test case");
	}
	
}
