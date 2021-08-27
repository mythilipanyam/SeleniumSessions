package webtable_traverse;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCrmPro_WebTable_Print {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("groupautomation");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(2000);
		printAllTheContactNames();
		
}
	public static void printAllTheContactNames() {
List<WebElement>namesList=driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr/td[2]/a"));
List<WebElement>pagesList=driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[2]/td[1]/div/a"));
// WebElement firstPage=driver.findElement(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[2]/td[1]/div/strong"));
 
  for(int i=0;i<pagesList.size();i++) {
	  for(int j=2;j<namesList.size();j++) {
		  String name= namesList.get(j).getText();
		  System.out.println(name);
	  }
	  System.out.println();
	  pagesList.get(i).click();
	  namesList=driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr/td[2]/a"));
	  pagesList=driver.findElements(By.xpath("//form[@id='vContactsForm']/table/tbody/tr[2]/td[1]/div/a"));
  }
  
	}
	}
