package action_class_methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
//Right click is also called context menu click
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		By rightClickEle=By.xpath("//span[text()='right click me']");
		By rightClickOptionsList=By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]/span");
		doRightClick(rightClickEle,rightClickOptionsList,"Copy");
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void doRightClick(By locator1,By locator2,String value) {
		Actions act=new Actions(driver);
		act.contextClick(getElement(locator1)).perform();	
		List<WebElement>optList=getElements(locator2);
		System.out.println(optList.size());
		for(WebElement e:optList) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
