package synchronization_concept;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");

		// Topcasting:child class object is refrred by parent interface reference
		// variable
		// Wait<WebDriver>wait=new FluentWait<WebDriver>(driver)
		// .withTimeout(Duration.ofSeconds(10))
		// .pollingEvery(Duration.ofMillis(2000))
		// .ignoring(NoSuchElementException.class);

		// wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("mpanyam@gmail.com");
		
		//The same methods can beused by using webdriverwait also-below example
	//	WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(2000))
				//.ignoring(NoSuchElementException.class);

		//wait.until(ExpectedConditions.presenceOfElementLocated(emailId)).sendKeys("mpanyam@gmail.com");

		waitForElementWithFluentWait(emailId, 10, 2000).sendKeys("mpanyam@gmail.com");
	}

	public static WebElement waitForElementWithFluentWait(By locator, int timeOut, long pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingInterval)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static WebDriver waitForFrameWithFluentWait(By locator, int timeOut, long pollingInterval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofMillis(pollingInterval)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));

	}

}