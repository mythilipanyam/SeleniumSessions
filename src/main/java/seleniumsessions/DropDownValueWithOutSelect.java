package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Very Famous interview question
public class DropDownValueWithOutSelect {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By countryOptions = By.xpath("//select[@id=\"Form_submitForm_Country\"]/option");
		//List<WebElement> countryOptionsList = driver.findElements(countryOptions);
		//for (WebElement e : countryOptionsList) {
			//String countryName = e.getText();
			//if (countryName.equals("Albania")) {
			//	e.click();
			//	break;
			//}

		//}
		chooseDropDownOptionWithOutSelectTag(countryOptions, "India");

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void chooseDropDownOptionWithOutSelectTag(By locator, String value) {
		List<WebElement> OptionsList = getElements(locator);

		System.out.println(OptionsList.size());

		for (WebElement e : OptionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
