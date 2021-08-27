package testNGsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest_BeforeTest {
//Browser will be launched only once because of beforetest method	
	
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.co.uk/");
    }
	
	@Test
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("page title is : "+title);
		Assert.assertEquals(title, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");	
	}
	
	@Test
	public void pageUrlTest() {
		String pageUrl=driver.getCurrentUrl();
		System.out.println("page url is : "+pageUrl);
		Assert.assertTrue(pageUrl.contains("amazon"));
	}
	
	@Test
	public void searchBoxTest() {
		WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
		Assert.assertTrue(searchBar.isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
