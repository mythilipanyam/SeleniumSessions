package action_class_methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {
//In Actions class, whenever there are more than one action then '.build().perform()' method is used
//When there is only one sigle action then .perform() method is used
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		By draggable=By.id("draggable");
		By droppable=By.id("droppable");
		//doDragAndDrop(draggable,droppable);
		doDragAndDropLongMethod(draggable,droppable);
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doDragAndDropLongMethod(By sourceEle,By targetEle) {
		Actions act=new Actions(driver);
		act.clickAndHold(getElement(sourceEle))
		.moveToElement(getElement(targetEle))
		.release(getElement(targetEle))
		.build()
		.perform();
		
	}
	public static void doDragAndDrop(By sourceEle,By targetEle) {
		Actions act=new Actions(driver);
		act.dragAndDrop(getElement(sourceEle),getElement(targetEle)).perform();
	}
	

}
