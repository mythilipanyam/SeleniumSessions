package synchronization_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//very famous interview question
public class CustomWait {
	static WebDriver driver;

	public static void main(String[] args) {
		// Use only thread.sleep method
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email2");
		retryingElement(emailId,10).sendKeys("mpanyam@gmail.com");

	}

	public static WebElement retryingElement(By locator, int maxAttempts) {
		WebElement element = null;
		int attempts = 0;
		while (attempts <maxAttempts) {
			try {
				element = driver.findElement(locator);
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("Element not found in " + (attempts + 1));
			}

			attempts++;

		}
		return element;
	}

}
