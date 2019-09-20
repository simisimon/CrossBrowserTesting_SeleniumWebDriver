package CrossBrowser_LieferandoTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CrossBrowser_BrowserSetUp.Browser;
import CrossBrowser_LieferandoPageObjects.Lieferando_StartPage;

public class Lieferando_StartPageTest extends Lieferando_TestSetUp {
	private static final String LOWER_HEADLINE = "Jetzt Restaurants in Deiner Umgebung finden";
	private static final String UPPER_HEADLINE = "Einfach Essen bestellen";

	@Parameters("search_input")
	@Test(priority=0)
	public void verifyStartPage(String location) throws InterruptedException {
		Lieferando_StartPage start_page = new Lieferando_StartPage(Browser.driver);

		start_page.loadPage();
		Reporter.log("Load Page");

		Assert.assertTrue(start_page.isLogoDisplayed());
		Reporter.log("Logo is visible");
		Assert.assertTrue(start_page.isHeadlineDisplayed());
		Reporter.log("Headline is visible");

		Assert.assertTrue(start_page.getHeadlineText().contains("Essen"));
		Reporter.log("Headline checked");
		Assert.assertTrue(start_page.getUpperHeadlineText().contains(UPPER_HEADLINE));
		Reporter.log("Upper headline checked");
		Assert.assertTrue(start_page.getLowerHeadlineText().contains(LOWER_HEADLINE));
		Reporter.log("Lower headline checked");

		start_page.setInputSearch(location);
		start_page.submitSearch();

		Thread.sleep(3000);

	}
}
