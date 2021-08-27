package xpath_css_sessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricInfoWebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/india-tour-of-sri-lanka-2021-1262739/sri-lanka-vs-india-3rd-odi-1262757/full-scorecard");
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(3000);
//driver.switchTo().frame("google_osd_static_frame");
//Thread.sleep(2000);
//driver.findElement(By.xpath("//button[text()='Not Now']")).click();
//driver.switchTo().defaultContent();
//Alert alert = driver.switchTo().alert();
//alert.accept();
//driver.switchTo().defaultContent();
		System.out.println(getWicketTakerName("Prithvi Shaw"));
		System.out.println(getWicketTakerName("Manish Pandey"));
		System.out.println(getWicketTakerName("Shikhar Dhawan"));
		System.out.println(getWicketTakerName("Sanju Samson"));
	System.out.println("------------------------------------------------");	
		System.out.println(getScoreCards("Prithvi Shaw"));
		System.out.println(getScoreCards("Manish Pandey"));
		System.out.println(getScoreCards("Shikhar Dhawan"));
		System.out.println(getScoreCards("Sanju Samson"));
	System.out.println("------------------------------------------------");		
		System.out.println(getBowlerInfo("Dushmantha Chameera"));
		System.out.println(getBowlerInfo("Akila Dananjaya"));
		System.out.println(getBowlerInfo("Chamika Karunaratne"));
		System.out.println(getBowlerInfo("Praveen Jayawickrama"));

	}

	public static String getWicketTakerName(String name) {
		String wktTaker = "//a[text()='" + name + "']//parent::td//following-sibling::td/span";
		return driver.findElement(By.xpath(wktTaker)).getText();
	}

	public static List<String> getScoreCards(String name) {
		String score = "//a[text()='"+name+"']//parent::td//following-sibling::td";
		List<WebElement> scrcard = driver.findElements(By.xpath(score));
		List<String> scoresList = new ArrayList<String>();
		for (int i = 1; i < scrcard.size(); i++) {
			String text = scrcard.get(i).getText();
			scoresList.add(text);
		}
		return scoresList;

	}

	public static List<String> getBowlerInfo(String name) {
		String bowler = "//a[text()='"+name+"']//parent::td//following-sibling::td";
		List<WebElement> bowlerCard= driver.findElements(By.xpath(bowler));
		List<String> bowlerInfo = new ArrayList<String>();
		for (int i = 0; i <bowlerCard.size(); i++) {
			String text = bowlerCard.get(i).getText();
			bowlerInfo.add(text);
		}
		return bowlerInfo;

	}
		
	}


