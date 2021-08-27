package synchronization_concept;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForListOfWebElements {


	  static WebDriver driver;
		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			By rhsPanelList=By.xpath("//div[@class='list-group']//a");
		List<String>linksListOnRHS=getElementTextList(5,rhsPanelList);
		
		System.out.println(linksListOnRHS.size());
		
		System.out.println("------------------------------------------------------------");
		for(int i=0;i<linksListOnRHS.size();i++) {
			System.out.println(linksListOnRHS.get(i));
		}
		System.out.println("------------------------------------------------------------");
		if(linksListOnRHS.contains("Returns")) {
			System.out.println("Returns test---pass");
		}
			

	}
		public static List<String> getElementTextList(int timeOut,By locator) {
			List<WebElement>eleList=waitForElementsToBeVisible(timeOut,locator);
			List<String>eleTextList=new ArrayList<String>();
			for(WebElement e:eleList) {
				eleTextList.add(e.getText());	
			}
			return  eleTextList;
		}
		
		public static List<WebElement> waitForElementsToBeVisible(int timeOut,By locator) {
			WebDriverWait wait=new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}

}
