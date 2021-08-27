package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQueryMultiSelectionWithCascadeOptionSelection {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox1")).click();
		// Thread.sleep(3000);
		By choiceList = By.cssSelector(".comboTreeItemTitle");

		selectChoice(choiceList, "choice 2");
		By subchoice1=By.xpath("//div[@id='comboTree729519DropDownContainer']//span[@class='comboTreeItemTitle'][normalize-space()='choice 2 1']");
	WebElement subset1=driver.findElement(subchoice1);
	if(subset1.isSelected()) {
		System.out.println("validation 1 passed");
	}
	else {
		System.out.println("validation 1 failed");
	}
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
//------------------------------------------------------------------------------------------
}
