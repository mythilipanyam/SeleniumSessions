package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		//chrome and firefox offer some options to perform the testing in headless  mode
		//headless mode: browser is not launched
		//tetsing will be done behind the scenes
		//webdriver interacts with html dom of the page directly
		//it is slightly faster than browser mode
		//the disadvantage is we do not have any visibility of the test execution
		//it is not recommended as it is suitable for popup handling
		// movetoelement method doesn't work in headless mode
		
		//WebDriverManager.chromedriver().setup();
		//ChromeOptions co=new ChromeOptions();
		//co.addArguments("--headless");
		//WebDriver driver=new ChromeDriver(co);
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions fo=new FirefoxOptions();
		fo.addArguments("--headless");
		WebDriver driver=new FirefoxDriver(fo);
		driver.get("https://www.amazon.co.uk/");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
