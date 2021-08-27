package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EssexWebsiteFooterLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.essex.gov.uk/");

		By footerLinks = By.xpath("//*[@id=\"main-footer\"]/div[1]/div/div/ul[1]//a");
		By accessibilityStatement = By.xpath("//*[@id=\"content\"]/div[1]/div/section/h2[1]");

		// List<WebElement> footerLinksList = driver.findElements(footerLinks);
		// System.out.println(footerLinksList.size());

		// for (WebElement e : footerLinksList) {
		// String footerLinkText = e.getText();
		// System.out.println(footerLinkText);
		// if (footerLinkText.equals("Accessibility")) {
		// e.click();
		// break;

		// }
		// }
		clickOnElement(footerLinks, "Accessibility");
		
		//validation
		System.out.println(doIsDisplayed(accessibilityStatement));

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void clickOnElement(By locator, String value) {
		List<WebElement> eleList = driver.findElements(locator);
		System.out.println(eleList.size());
		for (WebElement e : eleList) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	public static boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

}
