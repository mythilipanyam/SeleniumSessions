package runner_concept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	WebDriver driver;
	
    @Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browserName, String url) {
    	if(browserName.equals("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    	}
    	else if(browserName.equals("firefox")) {
    		WebDriverManager.firefoxdriver().setup();
    		driver = new FirefoxDriver();	
    	}
    	else if(browserName.equals("edge")) {
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();	
    	}
    	else {
    		System.out.println("Please supply correct browser...");
    	}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
    }
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}


}
