package CrossBrowser_MobileDeTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CrossBrowser_BrowserSetUp.Browser;
import CrossBrowser_MobileDePageObjects.MobileDe_DetailedSearchCar;
import CrossBrowser_MobileDePageObjects.MobileDe_SearchResultPage;

public class MobileDe_DetailedSearchTest extends MobileDe_Tests {
	
	private static final String FEATURE = "Tempomat";
	private static final String COUNTRY = "Deutschland";
	private static final String TRANSMISSION = "Automatik";
	private static final String FUEL = "Benzin";
	private static final String MIN_POWER = "200";
	private static final String MIN_PRICE = "75000";
	private static final String MAX_MILEAGE = "150000";
	private static final String MIN_YEAR = "2010";

	@DataProvider
	public Object[][] Cars() {
		return new Object[][] { 
			new Object[] { "Jaguar", "F-Type", "neu", "Coupe"},
		};
	}

	@Test(priority = 4, dataProvider = "Cars")
	public void verifyDetailedSearch(String brand, String model, String state, String type) throws InterruptedException {
		MobileDe_DetailedSearchCar detailed_search = new MobileDe_DetailedSearchCar(Browser.driver);
		
		detailed_search.clickDetailedSearch();
		Reporter.log("Detailed Search clicked");
		
		detailed_search.loadPage();
		Reporter.log("Load Page");
		
		detailed_search.setCarCondition(state);
		detailed_search.selectCar(brand, model);
		detailed_search.setCarType(type);
		Reporter.log("Parameter passed: " + brand +" " + model + " " + type);
		
		detailed_search.setMinYear(MIN_YEAR);
		detailed_search.setMaxMileage(MAX_MILEAGE);
		detailed_search.setMinPrice(MIN_PRICE);
		detailed_search.setMinPower(MIN_POWER);
		detailed_search.setFuel(FUEL);
		detailed_search.setTransmission(TRANSMISSION);
		detailed_search.selectCountry(COUNTRY);
		detailed_search.setFeatures(FEATURE);
		Reporter.log("Some parameter passed ");
		
		detailed_search.startUpperSearch();
		Reporter.log("Detailed Search started");
		
		MobileDe_SearchResultPage result_page = new MobileDe_SearchResultPage(Browser.driver);
		
		Assert.assertTrue(result_page.isMySearchDislayed());
		Reporter.log("My Detailed Search is displayey, DetailedSearch was successful");
		Assert.assertTrue(result_page.isSaveSearchDisplayed());
		Reporter.log("Detailed Search can be saved");
		
		result_page.goBack();
		Reporter.log("Returned to the home page");
		
		detailed_search.loadPage();
		Reporter.log("Load page");
		Thread.sleep(1000);
		
	}
}
