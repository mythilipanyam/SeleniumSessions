package frames_concept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//In java the inbuilt method that is already overloaded is '.frame()' method
//it can be used by index value, by string value and by provinding the webelement
//frame is also one webelement
public class LonDonFreelanceCourses {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		//Total no of frames on a webpage
		List<WebElement>frameList=driver.findElements(By.tagName("frame"));
		System.out.println(frameList.size());
		
		//By providing the index value
		//driver.switchTo().frame(4);-this method is not preferred//webdriver moves to the frame
		
		//By passing frame name or id
		//driver.switchTo().frame("content");//webdriver moves to the frame
		
		//By passing frame webelement-frame is also a webelement
		driver.switchTo().frame(driver.findElement(By.name("content")));//webdriver moves to the frame
		
		String text=driver.findElement(By.xpath("/html/body/h1")).getText();
		System.out.println(text);
		
		driver.switchTo().defaultContent();//Webdriver moves back to the original page
		
		}

}
