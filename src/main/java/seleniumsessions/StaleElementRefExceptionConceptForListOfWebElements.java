package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConceptForListOfWebElements {
//very imp interview question
//Stale element exception: whenever there is click or refresh or navigation to another page, the DOM also changes
// then in that case the referenced web element is no longer attached to the DOM and the web element becomes stale
//Stale means the element no longer appears on the DOM of the page.
//when the webdriver tries to interact with the element that is nolonger present in the DOM then we get staleelementexception

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		driver.findElement(By.xpath("//button[text()='ACCEPT ALL']")).click();
		Thread.sleep(3000);
		List<WebElement>list=driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
		for(int i=0;i<list.size();i++) {
			list.get(i).click();
			Thread.sleep(2000);
		//	driver.findElement(By.xpath("//button[text()='ACCEPT ALL']")).click();
			list=driver.findElements(By.xpath("(//ul[@class='footer-nav'])[1]//a"));
			
		}
	}

}
