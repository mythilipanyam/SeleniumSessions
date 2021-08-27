package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryDropDown {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		
		//With below method, we will get UnexpectedTagNameException: Element should have been "select" but was "input"
		//Select select = new Select(driver.findElement(By.id("justAnInputBox")));
		Thread.sleep(3000);
		By choiceList = By.cssSelector(".comboTreeItemTitle");

		// driver.findElement(choice).click();
		// List<WebElement>choicesList=driver.findElements(choiceList);
		// for(WebElement e:choicesList) {
		// String text=e.getText();
		// System.out.println(text);

		// }
		// single option selection
		// selectChoice(choiceList, "choice 2 1");

		// multiple options selection
		//selectChoice(choiceList,"choice 1","choice 2","choice 2 1");

		// All options selection
		selectChoice(choiceList, "All");

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// 3 dot String parameter(String... is an array of String values
	public static void selectChoice(By locator, String... value) {

		List<WebElement> choicesList = getElements(locator);

		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement e : choicesList) {
				String text = e.getText();
				System.out.println(text);

				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						e.click();
						break;
					}
				}

			}
		} else {
			// all options selection logic
			try {
				for (WebElement e : choicesList) {
					e.click();
				}
			} catch (Exception e) {

			}
		}

	}
}
