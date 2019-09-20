package CrossBrowser_MobileDePageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MobileDe_QuickSearchCar {
	private boolean isContained = false;
	private static WebDriver driver;

	private By quicksearch = By.id("quicksearch"); 

	private By tf_price = By.id("qsprc");
	private By tf_mileage = By.id("qsmil");
	private By tf_location = By.id("ambit-search-location");
	private By tf_year = By.id("qsfrg");

	private By sel_car_brand = By.id("qsmakeBuy");
	private By sel_car_model = By.id("qsmodelBuy");
	private By sel_country = By.id("ambit-search-country");

	private By link_change = By.className("u-text-right u-text-middle-32");

	private By input_benzin = By.id("qsfuel_PETROL");
	private By input_diesel = By.id("qsfuel_DIESEL");
	private By input_elktro = By.id("qsfuel_ELECTRICITY");
	private By input_hybrid = By.id("qsfuel_HYBRID");

	private By btn_fuel_apply = By.id("qssubfuel");
	private By btn_search = By.id("qssub");
	private By fuel_window = By.id("sio-fuel");

	private By minRegistrationDate = By.id("minFirstRegistrationDate");
	private By modelVariant = By.id("makeModelVariant-0");
	private By maxPrice = By.id("maxPrice");

	public MobileDe_QuickSearchCar(WebDriver driver) {
		MobileDe_QuickSearchCar.driver = driver;
	}

	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	public void goBack() {
		driver.navigate().back();
	}

	public boolean isQuickSearchVisible() {
		return driver.findElement(quicksearch).isDisplayed();
	}

	public void selectCarBrand(String brand) {
		Select brand_selection = new Select(driver.findElement(sel_car_brand));
		brand_selection.selectByVisibleText(brand);
	}

	public void selectCarModel(String model) {
		Select model_selection = new Select(driver.findElement(sel_car_model));
		model_selection.selectByVisibleText(model);
	}

	public void selectCountry(String country) {
		Select country_selection = new Select(driver.findElement(sel_country));
		country_selection.selectByVisibleText(country);
	}

	public void setYear(String year) {
		driver.findElement(tf_year).clear();
		driver.findElement(tf_year).sendKeys(year);
	}

	public boolean containsCarBrand(String brand) {
		Select brand_selection = new Select(driver.findElement(sel_car_brand));
		List<WebElement> brands = brand_selection.getOptions();

		int counter = brands.size();

		for (int i = 0; i < counter; i++) {
			if (brands.get(i).getText().equals(brand)) {
				isContained = true;
				break;
			} else {
				isContained = false;
			}
		}
		return isContained;
	}

	public boolean containsCarModel(String model) {
		Select model_selection = new Select(driver.findElement(sel_car_model));
		List<WebElement> models = model_selection.getOptions();

		int counter = models.size();

		for (int i = 0; i < counter; i++) {
			if (models.get(i).getText().equals(model)) {
				isContained = true;
				break;
			} else {
				isContained = false;
			}
		}
		return isContained;
	}

	public void setPrice(String price) {
		driver.findElement(tf_price).clear();
		driver.findElement(tf_price).sendKeys(price);

	}

	public void setMileAge(String mileage) {
		driver.findElement(tf_mileage).clear();
		driver.findElement(tf_mileage).sendKeys(mileage);
	}

	public void setLocation(String location) {
		driver.findElement(tf_location).clear();
		driver.findElement(tf_location).sendKeys(location);

	}

	public void clickChangeFuel() {
		driver.findElement(link_change).click();
	}

	public boolean isFuelWindowDisplayed() {
		return driver.findElement(fuel_window).isDisplayed();
	}

	public void changeFuel(String fuel) {
		if (fuel.equals("Benzin")) {
			driver.findElement(input_benzin).click();
			driver.findElement(btn_fuel_apply).submit();
		} else if (fuel.equals("Diesel")) {
			driver.findElement(input_diesel).click();
			driver.findElement(btn_fuel_apply).submit();
		} else if (fuel.equals("Elektro")) {
			driver.findElement(input_elktro).click();
			driver.findElement(btn_fuel_apply).submit();
		} else if (fuel.equals("Hybrid")) {
			driver.findElement(input_hybrid).click();
			driver.findElement(btn_fuel_apply).submit();
		}
	}

	public void startSearch() {
		driver.findElement(btn_search).submit();
	}

	public boolean compareBrand(String brand) {
		return driver.findElement(modelVariant).getText().equals(brand);
	}

	public boolean compareModel(String model) {
		return driver.findElement(sel_car_model).getText().equals(model);
	}

	public boolean comparePrice(String price) {
		return driver.findElement(maxPrice).getText().equals(price);
	}

	public boolean compareYear(String year) {
		return driver.findElement(minRegistrationDate).getText().equals(year);
	}
}
