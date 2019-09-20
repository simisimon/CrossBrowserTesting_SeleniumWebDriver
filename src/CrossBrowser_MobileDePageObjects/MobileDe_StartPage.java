package CrossBrowser_MobileDePageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MobileDe_StartPage {
	private static WebDriver driver;

	// WebElements
	private By search = By.className("font-gibson-semibold");
	private By detailed_search = By.id("qsdet");
	private By header_claim = By.className("mde-react-header__claim");
 
	private By btn_registration = By.id("hdmylogin");
	private By mymobile = By.id("hdmy");

	private By mobile_icon = By.className("mde-react-header__corporate-link");

	public MobileDe_StartPage(WebDriver driver) {
		MobileDe_StartPage.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getHeaderClaim() {
		return driver.findElement(header_claim).getText();

	}

	public void clickSearch() {
		driver.findElement(search).click();
	}

	public void clickDetailedSearch() {
		driver.findElement(detailed_search).click();
	}

	public void clickRegistration() {
		driver.findElement(btn_registration).click();
	}

	public boolean isMyMobileDisplayed() {
		return driver.findElement(mymobile).isDisplayed();
	}

	public boolean isMobileIconDisplayed() {
		return driver.findElement(mobile_icon).isDisplayed();
	}

	public boolean checkLinksEnabled() {
		return driver.findElement(btn_registration).isEnabled() && driver.findElement(mobile_icon).isEnabled();
	}
}
