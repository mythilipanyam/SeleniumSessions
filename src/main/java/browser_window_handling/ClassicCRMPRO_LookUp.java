package browser_window_handling;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCRMPRO_LookUp {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("New Contact")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@value='Lookup'])[1]")).click();
		
		Set<String>handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();
		String parentWindowId=it.next();
		String childWindowId=it.next();
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		List<WebElement>searchResults=driver.findElements(By.xpath("//tr/td/a"));
		for(WebElement e:searchResults) {
			String text=e.getText();
			if(text.equals("ABC")) {
				e.click();
			}
		}
		
		
		
	}

}
