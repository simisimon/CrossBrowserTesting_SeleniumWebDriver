package CrossBrowser_MobileDePageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileDe_SearchResultPage {

	private static WebDriver driver;

	private By link_saveSearch = By.id("saveSearchLink"); 
	private By link_newSearch = By.id("newSearchLink");

	private By link_mySearch = By.linkText("Meine Pkw-Suche");
	
	public MobileDe_SearchResultPage(WebDriver driver) {
		MobileDe_SearchResultPage.driver = driver;
	}

	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
	public boolean isMySearchDislayed() {
		return driver.findElement(link_mySearch).isDisplayed();
	}

	public boolean isNewSearchDisplayed() {
		return driver.findElement(link_newSearch).isDisplayed();
	}

	public boolean isSaveSearchDisplayed() {
		return driver.findElement(link_saveSearch).isDisplayed();
	}
}
