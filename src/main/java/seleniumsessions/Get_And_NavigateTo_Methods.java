package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Get_And_NavigateTo_Methods {
//There is no difference between get and navigate.to methods
// to method internally calls get method only
//They both are exactly same and they are synonyms
//Both the methods do not perform any actions on the webpage until the page is fully loaded
//There are four navigate methods
	//1. navigate().to()-lauches url
	//2. navigate().back()-clicks on browser back button
	//3. navigate().forward()-clicks on browser forward button
	//4. navigate().refresh()-refreshes the page

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		//driver.navigate().to("https://www.amazon.co.uk/");
		//System.out.println(driver.getTitle());
		driver.get("https://www.amazon.co.uk/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();//refreshes the page

	}

}
