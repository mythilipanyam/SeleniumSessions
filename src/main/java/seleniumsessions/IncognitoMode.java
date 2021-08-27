package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoMode {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions co=new ChromeOptions();
		//co.addArguments("--incognito");
	//WebDriver driver=new ChromeDriver(co);
		
		WebDriverManager.edgedriver().setup();
		EdgeOptions eo = new EdgeOptions();
        eo.setCapability("InPrivate", true);
	    WebDriver driver=new EdgeDriver(eo);
	
		driver.get("https://www.amazon.co.uk/");
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
