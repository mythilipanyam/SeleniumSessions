package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationConcept {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		
	List<WebElement>pages=driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
	int i=0;
	while(true) {
		if(driver.findElements(By.linkText("Mythili Panyam")).size()>0) {
			selectContact("Mythili Panyam");
			break;
		}
		else {
			//pagination logic
			try{pages.get(i).click();
			}catch(Exception e) {
				System.out.println("Pagination is completed..the contact name you supplied was not found..");
				e.printStackTrace();
				break;
			}
			pages=driver.findElements(By.xpath("(//div[@class='pagination'])[1]/a"));
		}
		i++;
	}
	

	}
	public static void selectContact(String contactName) {
		String name="//a[text()='"+contactName+"']//parent::td//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(name)).click();
		
	}

}
