package synchronization_concept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixingOfImplicitAndExplicitWaits {
	
	static WebDriver driver;

	public static void main(String[] args) {
		//imp wait + exp wait
		//never use both the waits together
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//it is a global wait and it is going to be applied
		//for all the webelements
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		WebDriverWait wait=new WebDriverWait(driver,10);//custom wait applied 
		wait.until(ExpectedConditions.presenceOfElementLocated(emailId));
		
		//Here both the waits are applied on emailid, so a cumulative wait is applied on that webelement
		//Here a cumulative effect of 20+10 secs will be applied
		

}
}