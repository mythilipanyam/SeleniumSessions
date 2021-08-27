package synchronization_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {
    static WebDriver driver;
	public static void main(String[] args) {
//explicit wait is available in the form of webdriverwait and fluentwait
//WebDriverwait is a kind of explicit wait and it is a dynamic wait
//explicit wait is a custom wait
//It can be applied for a specific webelement
//not aglobal wait
//can be applied for both webelements and nonwebelements
//explicit wait gives 'nosuchelementexception' and 'timeoutexception' if theelement is not found within the time
//explicit wait--the poll time is 500 milli seconds
//it means that it checks for the element for every 500 milli seconds
//The default polling time in selenium is 500 milli seconds
//the default polling time can be overridden

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By userName=By.name("username1");
		By password=By.name("password");
		By login=By.xpath("//input[@type='submit']");
		
		//wait is applied only for username
		//waitForElementPresence(5,userName).sendKeys("groupautomation");//default polling time of 500 milli seconds isapplied
		waitForElementPresence(5,1000,userName).sendKeys("groupautomation");//polling time is 1000 milli seconds
		
		//wait is not applied for other elements as it is not required
		driver.findElement(password).sendKeys("test@12345");
		driver.findElement(login).click();
		
		

	}
	public static WebElement waitForElementPresence(int timeOut,By locator) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static WebElement waitForElementPresence(int timeOut,int pollingTime,By locator) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut,pollingTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
