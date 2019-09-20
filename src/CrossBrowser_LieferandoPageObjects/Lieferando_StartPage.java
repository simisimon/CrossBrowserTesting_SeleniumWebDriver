package CrossBrowser_LieferandoPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lieferando_StartPage {
	
	private static WebDriver driver;

	private By input_search = By.name("mysearchstring");
	private By location = By.xpath("//*[@id=\"reference\"]");
	private By btn_show = By.className("submitBtn");
	
	private By logo = By.className("logo");
	private By btn_myaccount = By.className("menu button-myaccount userlogin");
	private By sel_language = By.id("locale");
	private By sel_country = By.id("country");
	
	private By headlines = By.className("headlines");
	private By upper_headline = By.className("headline-xl-raised");
	private By lower_headline = By.xpath("/html/body/header/div[1]/div[6]/div/div[1]/div");
	
	public Lieferando_StartPage(WebDriver driver) {
		Lieferando_StartPage.driver = driver;
	}
	
	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	public void setInputSearch(String input) {
		driver.findElement(input_search).clear();
		driver.findElement(input_search).sendKeys(input);
	}
	
	public void submitSearch() {
		driver.findElement(location).click();
	}
	
	public void startSearch() {
		driver.findElement(btn_show).click();
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean checkMenu() {
		return driver.findElement(btn_myaccount).isDisplayed() 
				&& driver.findElement(btn_myaccount).isEnabled();
	}
	
	public boolean checkLanguage() {
		return driver.findElement(sel_language).isDisplayed() 
				&& driver.findElement(sel_language).isEnabled();
	}
	
	public boolean checkCountry() {
		return driver.findElement(sel_country).isDisplayed() 
				&& driver.findElement(sel_country).isEnabled();
	}
	
	public boolean isHeadlineDisplayed() {
		return driver.findElement(headlines).isDisplayed();
	}
	
	public String getHeadlineText() {
		return driver.findElement(headlines).getText();
	}
	
	public String getUpperHeadlineText() {
		return driver.findElement(upper_headline).getText();
	}
	
	public String getLowerHeadlineText() {
		return driver.findElement(lower_headline).getText();
	}
	
}
