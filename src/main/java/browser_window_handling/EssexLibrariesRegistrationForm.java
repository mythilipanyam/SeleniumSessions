package browser_window_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EssexLibrariesRegistrationForm {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://tlc.ent.sirsidynix.net.uk/custom/web/registration/index.html?locale=en_GB&profile=essex");
			driver.manage().window().maximize();
			driver.findElement(By.id("patronAddress1_POSTALCODE_input")).sendKeys("CM1 7DU");
			driver.findElement(By.id("findNPLGAddress")).click();
			Thread.sleep(2000);
			//Set<String>handles=driver.getWindowHandles();
			//Iterator<String>it=handles.iterator();
			//String parentWIndowId=it.next();
			//String childtWIndowId=it.next();
			//driver.switchTo().window(childtWIndowId);
			//System.out.println(driver.getCurrentUrl());
			List<WebElement>addressList=driver.findElements(By.xpath("//div[@id='getAddressDiv']/p/a"));
			for(WebElement e:addressList) {
				String text=e.getText();
				if(text.equals("5 Longshots Close")) {
					e.click();
				}
			}
			
			

	}

}
