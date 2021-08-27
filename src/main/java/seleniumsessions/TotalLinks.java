package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;

//Ctrl+Shift+f - sets the format
//Ctrl+Shift+o - imports the WebDriver etc
//links always have 'a' tag
//driver.findelements will always return a list of webelement
//driver.findelement will always return a webelement
//	getting totla links and total images is called web scrapping and selenium webdriver can be used to scrap the data
	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// get the count of all the links
		// get the text of each link-do not want the blank links
		By links = By.tagName("a");
		List<WebElement> linksList = getElements(links);

		System.out.println(linksList.size());

		// for (int i = 0; i < linksList.size(); i++) {
		// System.out.println(linksList.get(i).getText());
		// }

		int i = 0;
		for (WebElement e : linksList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				System.out.println(i + ":" + text);
			}
			i++;
		}
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
