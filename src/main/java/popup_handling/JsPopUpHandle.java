package popup_handling;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsPopUpHandle {
	static WebDriver driver;

	public static void main(String[] args) {
		// For Javascript alerts-alert() method is used
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		By signInBtn = By.name("proceed");
		// driver.findElement(By.name("proceed")).click();
		// Alert alert = driver.switchTo().alert();// webdriver moves onto alert popup
		// String text = alert.getText();
		// System.out.println(text);
		// alert.accept();// clicks on ok
		// alert.dismiss();//does not accept the alert
		// driver.switchTo().defaultContent();// webdriver moves back to the main page
		// to continue with the normal work
		String alertMessage = doGetAlertText(signInBtn);
		// validation point
		if (alertMessage.equals("Please enter a valid user name")) {
			System.out.println("Correct alert message");
		} else {
			System.out.println("Incorrect alert message");
		}

		// doADismisstTheAlert(signInBtn);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static String doGetAlertText(By locator) {
		getElement(locator).click();
		Alert alert = driver.switchTo().alert();// webdriver moves onto alert popup
		String text = alert.getText();
		System.out.println(text);
		alert.accept();
		driver.switchTo().defaultContent();
		return text;

	}

	public static void doADismisstTheAlert(By locator) {
		getElement(locator).click();
		Alert alert = driver.switchTo().alert();// webdriver moves onto alert popup
		alert.dismiss();
		driver.switchTo().defaultContent();

	}

}
