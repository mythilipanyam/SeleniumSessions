package testNGsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderConcept {
	
	 WebDriver driver;
	@BeforeTest
	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/index.php?route=account/login");
	}
	
	@Test
	public void login_PositiveTest() {
	Assert.assertTrue(doLogin("naveenanimation20@gmail.com","Selenium12345"));
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		return new Object[][] {
			{"hapanyam@gmail.com","abcdef"},
			{"naveenanimation20@gmail.com","abcdef"},
			{"  ","Selenium12345"},
			{"naveenanimation20@gmail.com","  "},
			{" "," "}
	};
	}
	
	@Test(dataProvider="getLoginData")
    public void login_NegativeTest(String un,String pwd) {
		Assert.assertTrue(doLogin(un,pwd), "...error message not displayed...");
	}
	
    public boolean doLogin(String un,String pwd) {
    	driver.findElement(By.id("input-email")).clear();
    	driver.findElement(By.id("input-email")).sendKeys(un);
    	driver.findElement(By.id("input-password")).clear();
    	driver.findElement(By.id("input-password")).sendKeys(pwd);
    	driver.findElement(By.xpath("//input[@type='submit']")).click();
    	return driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).isDisplayed();
    	 
    }
	@AfterTest
	public void teardown() {
		//driver.quit();
	}

}
