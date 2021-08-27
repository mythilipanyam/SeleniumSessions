package action_class_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementMethod {
//Select class constructor-we have to pass webelement
//Actions class constructor-we have to pass driver

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/");
		By contentMenu=By.className("menulink");
		By articlesLink=By.linkText("ARTICLES");
		//WebElement contentMenu=driver.findElement(By.className("menulink"));
		//Actions act=new Actions(driver);
		//act.moveToElement(contentMenu).perform();
		//Thread.sleep(3000);
	//	driver.findElement(By.linkText("ARTICLES")).click();
		//Thread.sleep(3000);
		//act.moveToElement(contentMenu).perform();
		//Thread.sleep(3000);
		//driver.findElement(By.linkText("COURSES")).click();
		twoLevelMenuHandle(contentMenu,articlesLink);
		
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void twoLevelMenuHandle(By parentMenu,By childMenu) throws InterruptedException {
		Actions act=new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(0);
		getElement(childMenu).click();
	}

}
