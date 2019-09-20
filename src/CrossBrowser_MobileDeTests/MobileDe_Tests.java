package CrossBrowser_MobileDeTests;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import CrossBrowser_BrowserSetUp.Browser;

public class MobileDe_Tests {
	Browser multibrowser = new Browser(null);

	@BeforeTest
	@Parameters({ "browser", "url" })
	public void beforeTest(String browser, String url) {

		multibrowser.init_browser(browser);
		Reporter.log("Browser initialized");
		multibrowser.maximize_window();
		Reporter.log("Browser Maximized");
		multibrowser.wait(5);
		multibrowser.getURL(url);
		Reporter.log("Application started");

	}

	@AfterTest
	public void afterTest() {
		multibrowser.end_browser();
	}
}
