package CrossBrowser_MobileDePageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MobileDe_DetailedSearchCar {

	private static WebDriver driver;
	private By link_detailedSearch = By.id("qsdet");
	private By header_text = By.className("u-pull-left sticky-header"); 

	private By input_new = By.id("usage-NEW-ds");
	private By input_used = By.id("usage-USED-ds");

	private By sel_car_brand = By.id("selectMake1-ds");
	private By sel_car_model = By.id("selectModel1-ds");
	private By tf_model_description = By.id("modelDescription1-ds");

	private By input_cabrio = By.id("categories-Cabrio-ds");
	private By input_limousine = By.id("categories-Limousine-ds");
	private By input_coupe = By.id("categories-SportsCar-ds");
	private By input_smallcar = By.id("categories-SmallCar-ds");

	private By input_minSeats = By.id("minSeats");
	private By input_maxSeats = By.id("maxSeats");

	private By tf_minyear = By.id("minFirstRegistrationDate");
	private By tf_minmileage = By.id("maxMileage");
	private By tf_minprice = By.id("minPrice");
	private By tf_minpower = By.id("minPowerAsArray");

	private By input_petrol = By.id("fuels-PETROL-ds");
	private By input_diesel = By.id("fuels-DIESEL-ds");
	private By input_elektro = By.id("fuels-ELECTRICITY-ds");
	private By input_manuel = By.id("transmissions-MANUAL_GEAR-ds");
	private By input_automatic = By.id("transmissions-AUTOMATIC_GEAR-ds");

	private By sel_country = By.id("ambit-search-country");
	private By tf_location = By.id("ambit-search-location");

	private By input_black = By.id("color-BLACK-ds");
	private By input_white = By.id("color-WHITE-ds");

	private By input_heated_seats = By.id("features-ELECTRIC_HEATED_SEATS-ds");
	private By input_onboard_pc = By.id("features-ON_BOARD_COMPUTER-ds");
	private By input_cruise_controll = By.id("features-CRUISE_CONTROL-ds");
	
	private By btn_upperSearch = By.id("dsp-upper-search-btn");
	private By btn_lowerSearch = By.id("dsp-lower-search-btn");
	
	public MobileDe_DetailedSearchCar(WebDriver driver) {
		MobileDe_DetailedSearchCar.driver = driver;
	}
	
	public void loadPage() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public void clickDetailedSearch() {
		driver.findElement(link_detailedSearch).click();
	}
	
	public boolean isDetailedSearchDisplayed() {
		return driver.findElement(header_text).isDisplayed();
	}
	
	public String getHeaderText() {
		return driver.findElement(header_text).getText();
		
	}

	public void setCarCondition(String condition) {
		if (condition.equals("neu")) {
			driver.findElement(input_new).click();
		} else {
			driver.findElement(input_used).click();
		}
	}

	public void selectCar(String brand, String model) {
		Select brand_selection = new Select(driver.findElement(sel_car_brand));
		brand_selection.selectByVisibleText(brand);
		
		Select model_selection = new Select(driver.findElement(sel_car_model));
		model_selection.selectByVisibleText(model);
	}

	public void typeCarType(String type) {
		driver.findElement(tf_model_description).clear();
		driver.findElement(tf_model_description).sendKeys(type);
	}

	public void setCarType(String car_type) {
		if (car_type.equals("Coupe")) {
			driver.findElement(input_coupe).click();
		} else if (car_type.equals("Cabrio")) {
			driver.findElement(input_cabrio).click();
		} else if (car_type.equals("Limousine")) {
			driver.findElement(input_limousine).click();
		} else if (car_type.equals("Kleinwagen")) {
			driver.findElement(input_smallcar).click();
		}
	}

	public void setMinSeats(String minseats) {
		driver.findElement(input_minSeats).clear();
		driver.findElement(input_minSeats).sendKeys(minseats);
	}

	public void setMaxSeats(String maxseats) {
		driver.findElement(input_maxSeats).clear();
		driver.findElement(input_maxSeats).sendKeys(maxseats);
	}

	public void setMinYear(String minyear) {
		driver.findElement(tf_minyear).clear();
		driver.findElement(tf_minyear).sendKeys(minyear);
	}

	public void setMaxMileage(String minmileage) {
		driver.findElement(tf_minmileage).clear();
		driver.findElement(tf_minmileage).sendKeys(minmileage);
	}

	public void setMinPrice(String minprice) {
		driver.findElement(tf_minprice).clear();
		driver.findElement(tf_minprice).sendKeys(minprice);
	}

	public void setMinPower(String minpower) {
		driver.findElement(tf_minpower).clear();
		driver.findElement(tf_minpower).sendKeys(minpower);
	}

	public void setFuel(String fuel) {
		if (fuel.equals("Benzin")) {
			driver.findElement(input_petrol).click();
		} else if (fuel.equals("Diesel")) {
			driver.findElement(input_diesel).click();
		} else if (fuel.equals("Elektro")) {
			driver.findElement(input_elektro).click();
		}
	}

	public void setTransmission(String transmission) {
		if (transmission.equals("Automatik")) {
			driver.findElement(input_automatic).click();
		} else {
			driver.findElement(input_manuel).click();
		}
	}

	public void selectCountry(String country) {
		Select country_selection = new Select(driver.findElement(sel_country));
		country_selection.selectByVisibleText(country);
	}

	public void typeLocation(String location) {
		driver.findElement(tf_location).clear();
		driver.findElement(tf_location).sendKeys(location);
	}

	public void setColour(String colour) {
		if (colour.equals("Schwarz")) {
			driver.findElement(input_black).click();
		} else {
			driver.findElement(input_white).click();
		}
	}

	public void setFeatures(String feature) {
		if (feature.equals("Sitzheizung")) {
			driver.findElement(input_heated_seats).click();
		} else if (feature.equals("Tempomat")) {
			driver.findElement(input_cruise_controll).click();
		} else if (feature.equals("Boardcomputer")) {
			driver.findElement(input_onboard_pc).click();
		}
	}
	
	public void startUpperSearch() {
		driver.findElement(btn_upperSearch).click();
	}
	
	public void startLowerSearch() {
		driver.findElement(btn_lowerSearch).click();
	}
}
