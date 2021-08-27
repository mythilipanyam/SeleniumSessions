package calendar_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryRegistrationForm {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://tlc.ent.sirsidynix.net.uk/custom/web/registration/index.html?locale=en_GB&profile=essex");

		driver.findElement(By.cssSelector("input#patron_birthDate_input")).click();
		Thread.sleep(2000);

		selectDOB("Jun", "2021", "29");

	}

	public static void selectDOB(String expMonth, String expYear, String expDay) {

		if (Integer.parseInt(expDay) > 31) {
			return;
		}

		if (Integer.parseInt(expYear) > 2021 && expMonth.equals("Sep")) {
			return;
		}

		String month = "//select[@class='ui-datepicker-month']//option[text()='" + expMonth + "']";
		String year = "//select[@class='ui-datepicker-year']//option[text()='" + expYear + "']";
		String day = "//td[@data-handler='selectDay']/a[text()='" + expDay + "']";
		driver.findElement(By.xpath(month)).click();
		driver.findElement(By.xpath(year)).click();
		driver.findElement(By.xpath(day)).click();

	}
}
