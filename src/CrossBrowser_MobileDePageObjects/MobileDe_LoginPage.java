package CrossBrowser_MobileDePageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileDe_LoginPage {
	private static final String LOGIN_URL = "https://login.mobile.de/mycas/login?requestLogin=true&lang=de&redirect=true&service=https%3A%2F%2Fwww.mobile.de%2F";

	private static WebDriver driver;

	private By tf_email = By.id("login-username"); 
	private By tf_password = By.id("login-password");

	private By btn_registration = By.id("hdmylogin");
	private By btn_submit_registration = By.id("loginSubmitButton");
	
	private By link_my_mobile_de = By.xpath("//*[@id=\"hdmy\"]");
	private By link_logout = By.linkText("Ausloggen");
	
	private By message_container = By.xpath("//*[@id=\"container\"]/div[1]/div/div");
	private By message = By.xpath("//*[@id=\"container\"]/div[1]/div/div/div/span");

	private By logo_startpage = By.className("mobile-logo de");
	
	public MobileDe_LoginPage(WebDriver driver) {
		MobileDe_LoginPage.driver = driver;
	}
	public void getLoginURL() {
		driver.get(LOGIN_URL);
	}
	
	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void goBack() {
		driver.navigate().back();
	}

	public void setEmail(String email) {
		driver.findElement(tf_email).clear();
		driver.findElement(tf_email).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(tf_password).clear();
		driver.findElement(tf_password).sendKeys(password);
	}
	
	public boolean isRegistrationDisplayed() {
		return driver.findElement(btn_registration).isDisplayed();
	}
	
	public void clickRegistration() {
		driver.findElement(btn_registration).click();
	}
	
	public void submitRegistration() {
		driver.findElement(btn_submit_registration).submit();
	}
	
	public void clickMyMobileDe() {
		driver.findElement(link_my_mobile_de).click();
	}
	
	public void clickLogOut() {
		driver.findElement(link_logout).click();
	}
	
	public void returnToStartPage() {
		driver.findElement(logo_startpage).click();
	}
	
	public boolean isMyMobileDisplayed() {
		return driver.findElement(link_my_mobile_de).isDisplayed();
	}
	
	public boolean isWarningMessageDisplayed() {
		return driver.findElement(message).isDisplayed() &&
				driver.findElement(message_container).isDisplayed();
	}
	
	public String getMessageText() {
		return driver.findElement(message).getText();
	}
}
