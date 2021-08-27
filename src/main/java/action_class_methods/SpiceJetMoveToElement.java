package action_class_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetMoveToElement {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://book.spicejet.com/Login.aspx");
By loginMenu=By.id("Login");
By spiceClubMember=By.xpath("//*[@id=\"menu-list-login\"]/li[1]/a");
By signUp=By.linkText("Sign up");
		//WebElement loginMenu = driver.findElement(By.id("Login"));
		//WebElement spiceClubMember = driver.findElement(By.xpath("//*[@id=\"menu-list-login\"]/li[1]/a"));
		// WebElement memberLogin=driver.findElement(By.linkText("Member Login"));
		//Actions act = new Actions(driver);
		//act.moveToElement(loginMenu).perform();
		//Thread.sleep(2000);
		//act.moveToElement(spiceClubMember).perform();
		//Thread.sleep(2000);
		// act.moveToElement(memberLogin);
		// driver.findElement(By.linkText("Member Login")).click();
		//driver.findElement(By.linkText("Sign up")).click();
		threeLevelMenuHandle(loginMenu, spiceClubMember, signUp);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void threeLevelMenuHandle(By parentMenu1, By parentMenu2, By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(parentMenu2)).perform();
		Thread.sleep(2000);
        getElement(childMenu).click();
	}

}
