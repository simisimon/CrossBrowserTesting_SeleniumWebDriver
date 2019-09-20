package CrossBrowser_BrowserSetUp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	 
	private String pathToIED = "D:\\\\Programme\\WebDriver\\InternetExplorerDriver\\MicrosoftWebDriver.exe";
	 
	public Browser(WebDriver driver) {
		Browser.driver = driver;
	}
	
	public WebDriver init_browser(String browser) {
		if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", pathToIED);
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public void wait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	public void getURL(String url) {
		driver.get(url);
	}
	
	public void maximize_window() {
		driver.manage().window().maximize();
	}
	
	public void end_browser() {
		driver.quit();
	}
	
}

