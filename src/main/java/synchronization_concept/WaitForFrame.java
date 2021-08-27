package synchronization_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrame {
//Frame is a webelement

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		//waitForFrameAndSwitchToItByFrameName(5,"mainpanel");
		
		//By name=By.xpath("//frame[@name='mainpanel']");
		//waitForFrameAndSwitchToItByLocator(5, name);
		//WebElement frameName=driver.findElement(name);
		
		//waitForFrameAndSwitchToItByWebElement(5, frameName);
		
		waitForFrameAndSwitchToItByIndex(5,1);
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void waitForFrameAndSwitchToItByFrameName(int timeOut,String frameName) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
	}
	public static void waitForFrameAndSwitchToItByLocator(int timeOut, By frameLocator) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void waitForFrameAndSwitchToItByWebElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}
	public static void waitForFrameAndSwitchToItByIndex(int timeOut,int frameIndex) {
		WebDriverWait wait=new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	

}
