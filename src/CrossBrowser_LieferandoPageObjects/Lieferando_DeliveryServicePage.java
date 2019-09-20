package CrossBrowser_LieferandoPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lieferando_DeliveryServicePage {

	private static WebDriver driver;

	private By logo = By.cssSelector("div.logo:nth-child(2)");
	private By myaccount = By.cssSelector(".myaccount");
	private By locale = By.id("locale");
	private By country = By.id("country");

	private By restaurant_list = By.id("irestaurantlist");
	private By restaurant_filter = By.className("restaurants-filter");

	private By filter_kitchen = By.className("filter-kitchen");
	private By filter_ratings = By.xpath("/html/body/div[2]/div/div[1]/div/div[3]");
	private By filter_delivery_costs = By.xpath("/html/body/div[2]/div/div[1]/div/div[4]");

	private By dropdown_location = By.id("dropdown-location");

	public Lieferando_DeliveryServicePage(WebDriver driver) {
		Lieferando_DeliveryServicePage.driver = driver;
	}

	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}

	public boolean checkMyAccount() {
		return driver.findElement(myaccount).isDisplayed() 
				&& driver.findElement(myaccount).isEnabled();
	}

	public boolean checkSelectCountry() {
		return driver.findElement(country).isDisplayed() 
				&& driver.findElement(country).isEnabled();
	}

	public boolean checkSelectLocation() {
		return driver.findElement(locale).isDisplayed() 
				&& driver.findElement(locale).isEnabled();
	}

	public boolean isRestaurantListDisplayed() {
		return driver.findElement(restaurant_list).isDisplayed();
	}

	public boolean isRestaurantFilterDisplayed() {
		return driver.findElement(restaurant_filter).isDisplayed();
	}

	public boolean isKitchenFilterDisplayed() {
		return driver.findElement(filter_kitchen).isDisplayed();
	}

	public boolean isCostFilterDisplayed() {
		return driver.findElement(filter_delivery_costs).isDisplayed();
	}

	public boolean isRatingDisplayed() {
		return driver.findElement(filter_ratings).isDisplayed();
	}

	public String getSearchLocationText() {
		return driver.findElement(dropdown_location).getText();
	}
}
