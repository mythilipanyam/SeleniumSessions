package action_class_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndActionsClick {
//Actions sendkeys method is equivalent to clicking on the element first and then entering the value
//driver.sendkeys method is just entering the value
//Actions click method goes to the middle of the element and then clicks on the element
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailID=By.id("input-email");
		By pwrd=By.id("input-password");
		By loginButton=By.xpath("//input[@type='submit']");
		
		doSendKeysByActions(emailID,"mpanyam@gmail.com");
		doSendKeysByActions(pwrd,"password");
		doClickByActions(loginButton);

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSendKeysByActions(By locator,String value) {
		Actions act=new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
	public static void doClickByActions(By locator) {
		Actions act=new Actions(driver);
		act.click(getElement(locator)).perform();
	}

}
