package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementIsDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.get("https://demo.opencart.com/index.php?route=account/register");
		 By search=By.name("search");
		 By search_button=By.cssSelector("#search > span > button > i");
		 By search_term=By.cssSelector("#content > h1");
		 if(doisdislayed(search)) {
			 dosendkeys(search,"macbook");
			 doclick(search_button);
			String searchterm=dogettext(search_term);
			if(searchterm.equals("Search - macbook")) {
				System.out.println("Correct Search");
			}
			else {
				System.out.println("Incorrect Search");
			}
		 }
		 else {
			 System.out.println("Search box not displayed");
		 }
		 
    }
	public static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static boolean doisdislayed(By locator) {
		return findElement(locator).isDisplayed();
	}
	public static void dosendkeys(By locator,String value) {
		findElement(locator).sendKeys(value);
	}
	
	public static void doclick(By locator) {
		findElement(locator).click();
	}
	public static String dogettext(By locator) {
		return findElement(locator).getText();
	}

}
