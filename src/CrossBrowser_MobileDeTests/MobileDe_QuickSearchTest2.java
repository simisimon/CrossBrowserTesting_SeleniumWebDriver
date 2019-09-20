package CrossBrowser_MobileDeTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CrossBrowser_BrowserSetUp.Browser;
import CrossBrowser_MobileDePageObjects.MobileDe_QuickSearchCar;
import CrossBrowser_MobileDePageObjects.MobileDe_SearchResultPage;

public class MobileDe_QuickSearchTest extends MobileDe_Tests{
	
	private static final String LOCATION = "Magdeburg";
	private static final String COUNTRY = "Deutschland";
	
	@DataProvider
	public Object[][] Cars() {
		return new Object[][] { 
			new Object[] { "Porsche", "Panamera", "150000", "2015", "75000"},
			new Object[] { "Audi", "A5", "30000", "2010", "150000"},
			new Object[] { "Volkswagen", "Beetle", "25000", "2007", "90000"}
		};
	}
	
	@Test(priority = 3, dataProvider = "Cars")
	public void verifyQuickSearch(String brand, String model, String price, String year, String mileage) throws InterruptedException {
		Reporter.log("Start verify quick search");
		MobileDe_QuickSearchCar quick_search 
		= new MobileDe_QuickSearchCar(Browser.driver);
		
		checkQuickSearchElement(quick_search);

		Assert.assertTrue(quick_search.containsCarBrand(brand));
		Reporter.log("Car brand " + brand + " is available");

		quick_search.selectCarBrand(brand);
		quick_search.selectCarModel(model);
		quick_search.selectCountry(COUNTRY);
		quick_search.setPrice(price);
		quick_search.setYear(year);
		quick_search.setMileAge(mileage);
		quick_search.setLocation(LOCATION);
		Reporter.log("Parameter passed");
		
		quick_search.startSearch();
		Reporter.log("QuickSearch started");
		
		MobileDe_SearchResultPage result_page = new MobileDe_SearchResultPage(Browser.driver);
		
		checkResultPage(result_page);
	}

	public void checkQuickSearchElement(MobileDe_QuickSearchCar quick_search) {
		quick_search.loadPage();
		Reporter.log("Load page");

		Assert.assertTrue(quick_search.isQuickSearchVisible());
		Reporter.log("QuickSearch is visible");
	}
	
	public void checkResultPage(MobileDe_SearchResultPage result_page) throws InterruptedException {
		Assert.assertTrue(result_page.isMySearchDislayed());
		Reporter.log("My QuickSearch is displayey, QuickSearch was successful");
		Assert.assertTrue(result_page.isSaveSearchDisplayed());
		Reporter.log("QuickSearch can be saved");

		Thread.sleep(1000);
		result_page.goBack();
		Reporter.log("Returned to the home page");
		Thread.sleep(2000);
	}
}
