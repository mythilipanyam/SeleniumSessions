package synchronization_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
//difference between presence of an element and visibility of an element is an imp question for interviews
//The definition is in method description
public class WaitForWebElement {
    static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId=By.id("input-email");
		//waitForElementPresence(5,emailId).sendKeys("groupautomation");
		// waitForElementVisibilityUsingByLocator(5,emailId).sendKeys("groupautomation");
		waitForElementVisibilityUsingWebElement(5,emailId).sendKeys("groupautomation");
		
		By forgotPaswrd=By.linkText("Forgotten Password");
		clickWhenReady(5,forgotPaswrd);
		 

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible on the web page
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementPresence(int timeOut,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.
	 * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
	 * @param timeOut
	 * @param locator
	 * @return
	 */
	public static WebElement waitForElementVisibilityUsingByLocator(int timeOut,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisibilityUsingWebElement(int timeOut,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}
	
	/**
	 * An expectation for checking an element is visible and enabled such that you can click it.
	 * @param timeOut
	 * @param locator
	 * @return 
	 */
	public static WebElement waitForElementToBeClickable(int timeOut,By locator) {
		WebDriverWait wait=new WebDriverWait (driver,timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public static void clickWhenReady(int timeOut,By locator) {
		waitForElementToBeClickable(timeOut,locator).click();
	}
	

}
