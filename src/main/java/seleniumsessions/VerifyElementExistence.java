package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElementExistence {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By forgotpwdLink=By.linkText("Forgotten Password");
		//verifyElementPresence(forgotpwdLink);
		if(verifyElementPresence(forgotpwdLink)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}

	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static boolean verifyElementPresence(By locator) {
		List<WebElement> eleList=getElements(locator);
		if( eleList.size()>0) {
			System.out.println("Element is present on the webpage");
			return true;
		}
		System.out.println("Element is not present on the webpage");
		return false;
	}

}
