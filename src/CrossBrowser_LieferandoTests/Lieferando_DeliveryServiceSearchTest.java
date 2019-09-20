package CrossBrowser_LieferandoTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CrossBrowser_BrowserSetUp.Browser;
import CrossBrowser_LieferandoPageObjects.Lieferando_DeliveryServicePage;

public class Lieferando_DeliveryServiceSearchTest extends Lieferando_TestSetUp {
	
  @Parameters("search_input")
  @Test(priority=1)
  public void verifySearch(String location) {
	  Lieferando_DeliveryServicePage delivery_page = new Lieferando_DeliveryServicePage(Browser.driver);
	  
	  delivery_page.loadPage();
	  Reporter.log("Load Page");
	  
	  Assert.assertTrue(delivery_page.isLogoDisplayed());
	  Reporter.log("Logo is displayed");
	  Assert.assertTrue(delivery_page.checkMyAccount());
	  Reporter.log("MyAccount checked");
	  Assert.assertTrue(delivery_page.checkSelectCountry());
	  Reporter.log("SelectCountry checked");
	  Assert.assertTrue(delivery_page.checkSelectLocation());
	  Reporter.log("SelectLocation checked");
	  
	  
	  Assert.assertTrue(delivery_page.isRestaurantListDisplayed());
	  Reporter.log("List of restaurants is displayed");
	  Assert.assertTrue(delivery_page.isRestaurantFilterDisplayed());
	  Reporter.log("Filter for restaurants are displayed");
	  Assert.assertTrue(delivery_page.isKitchenFilterDisplayed());
	  Reporter.log("Kitchen filter is displayed");
	  Assert.assertTrue(delivery_page.isRatingDisplayed());
	  Reporter.log("Ratings are displayed");
	  Assert.assertTrue(delivery_page.isCostFilterDisplayed());
	  Reporter.log("Filter of costs are displayed");
  
	  Assert.assertTrue(delivery_page.getSearchLocationText().contains(location));
	  Reporter.log("Search input checked");
	  
	  
  }
}
