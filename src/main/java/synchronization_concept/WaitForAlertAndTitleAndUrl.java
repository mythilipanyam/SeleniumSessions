package synchronization_concept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertAndTitleAndUrl {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	//	By signInBtn = By.name("proceed");
	//	driver.findElement(signInBtn).click();
	//	String text=getAlertText(5);
	//	System.out.println(text);
		
		//title
		//String title=waitForTitleContains(5,"mail");
		//System.out.println(title);
		
		//String fullTitle=waitForTitleIs(5,"Rediffmail");
		//System.out.println(fullTitle);
		
		//Urls:
		driver.findElement(By.xpath("//u[text()='Forgot Password?']")).click();
		String url= waitForUrlContains(5,"/newforgot");
		System.out.println(url);
		
	String fullUrl=	waitForFullUrl(5,"https://register.rediff.com/utilities/newforgot/index.php?FormName=showlogin");
    System.out.println(fullUrl);

	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeOut) {
		String text = waitForAlert(timeOut).getText();
		waitForAlert(timeOut).accept();
		return text;
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();;
	}
	
	public static void doSendKeysOnAlert(int timeOut,String value) {
		waitForAlert(timeOut).sendKeys(value);
	}
	
	public static String waitForTitleContains(int timeOut,String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if( wait.until(ExpectedConditions.titleContains(titleValue))){
			return driver.getTitle();
		}
		return null;
	}
	public static String waitForTitleIs(int timeOut,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if( wait.until(ExpectedConditions.titleIs(title))){
			return driver.getTitle();
		}
		return null;
	}
	public static String waitForUrlContains(int timeOut,String UrlFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if( wait.until(ExpectedConditions.urlContains(UrlFraction))){
			return driver.getCurrentUrl();
		}
		return null;
	}
	public static String waitForFullUrl(int timeOut,String Url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if( wait.until(ExpectedConditions.urlToBe(Url))){
			return driver.getCurrentUrl();
		}
		return null;
	}
	
	
	
	

}
