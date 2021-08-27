package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		By footerLinks=By.xpath("//div[@class=\"navFooterVerticalRow navAccessibility\"]//a");
		List<String>footerLinksList=getLinksTextList(footerLinks);
		
		//validation points
		if(footerLinksList.size()==22) {
			System.out.println("Footer links count is correct");
		}
		if(footerLinksList.contains("Amazon App Download")) {
			System.out.println("Amazon App info is present");
		}
		

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getLinksTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		System.out.println("Element count: " + eleList.size());
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}

		}
		return eleTextList;
	}

}
