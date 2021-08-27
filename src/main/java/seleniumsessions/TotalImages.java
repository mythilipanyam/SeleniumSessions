package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//All the images have tag of <img>
public class TotalImages {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// get the count of all the images
		By images = By.tagName("img");
		List<WebElement> imgList = getElements(images);

		System.out.println(imgList.size());
		//for(int i=0;i<imgList.size();i++) {
			//String altValue=imgList.get(i).getAttribute("alt");
			//System.out.println(i+":"+altValue);
		//}
		for(WebElement e:imgList) {
			String altValue=e.getAttribute("alt");
			System.out.println(altValue);
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
