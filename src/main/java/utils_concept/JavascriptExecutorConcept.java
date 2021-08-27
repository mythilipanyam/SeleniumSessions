package utils_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorConcept {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.co.uk/");
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);
		//jsUtil.refreshBrowserByJS();
		//String innerText = jsUtil.getPageInnerText();
		//System.out.println(innerText);
		
		//jsUtil.generateAlert("Hi this is my alert");
		//driver.switchTo().alert().dismiss();
		//driver.switchTo().defaultContent();
		
		WebElement acceptbtn=driver.findElement(By.cssSelector("input#sp-cc-accept"));
		jsUtil.flash(acceptbtn);
		jsUtil.clickElementByJS(acceptbtn);
		
		//WebElement searchBar=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		//jsUtil.flash(searchBar);
		
		//WebElement signIn=driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		//jsUtil.flash(signIn);
		//signIn.click();
		
		//WebElement emailId=driver.findElement(By.id("ap_email"));
		//jsUtil.flash(emailId);
		//emailId.sendKeys("jdsahfashfasn ");
		//WebElement continueBtn=driver.findElement(By.id("continue"));
		//jsUtil.flash(continueBtn);
		//continueBtn.click();
		
		//jsUtil.scrollPageDown();
		//jsUtil.scrollPageUp();
		//jsUtil.scrollPageDown("500");
		WebElement trendingDeals=driver.findElement(By.xpath("//h2[text()='Trending Deals']"));
		jsUtil.scrollIntoView(trendingDeals);
		jsUtil.drawBorder(trendingDeals);
		
		
	}

}
