package utils_concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
     private WebDriver driver;
	
	/**
	 * This method is for initialising the driver based on the browser name supplied
	 *  @param
	 *  @return WebDriver reference variable
	 */
	public WebDriver launchingBrowser(String browserName) {
		
		if (browserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else {
			System.out.println("Please pass the correct browser.......");
		}
		return driver;
	}
	
	/**
	 * This method is for launching url
	 * @param url
	 */
	public void launchUrl(String url) {
		
		if(url==null) {
			return;
		}
		 if(url.isEmpty()) {
			return;
		}
		driver.get(url);
		}
 	
	
	/**
	 * This method is for getting the page title
	 * @return title
	 */
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	/**
	 * This method is for getting current page url
	 * @return current url
	 */
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * This method is for getting page source
	 * @return page source
	 */
	public String getPageSource() {
		return driver.getPageSource();
	}
	
	/**
	 * This method is for closing the current browser instance
	 */
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * This method is for closing all the browser instances
	 */
	public void quitBrowser() {
		driver.quit();
	}
	
}





