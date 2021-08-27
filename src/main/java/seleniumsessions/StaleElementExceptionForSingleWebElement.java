package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//When the page is refreshed the webelement id gets expired and is no longer valid
//thats we need to update the webelement once again after the page refresh
public class StaleElementExceptionForSingleWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		WebElement emailId=driver.findElement(By.id("input-email"));
		emailId.sendKeys("test@gmail.com");
		
		driver.navigate().refresh();//Dom also gets refreshed, thats why the earlier webelement becomes stale  
		//which means no longer is fresh
		//to overcome this issue, we need to update the webelemnt once again--see below
		
		emailId=driver.findElement(By.id("input-email"));
		emailId.sendKeys("mpanyam@gmail.com");
	

	}

}
