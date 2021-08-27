package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverBasics {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\panya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.edge.driver","C:\\Users\\panya\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\panya\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		//Child class object(chromedriver) is referred by parent interface(webdriver) refrence variable-topcasting 
		
		WebDriver driver=new ChromeDriver();//launch the browser
		//WebDriver driver=new FirefoxDriver();
		//WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.Google.com");//launch the url
        System.out.println(driver.getTitle());//get the title
        
        //validation 
        if(driver.getTitle().equals("Google")) {
        	System.out.println("Correct Title");
        }else {
        	System.out.println("Incorrect Title");
        }
        
        //get the url
        System.out.println(driver.getCurrentUrl()); //get the current url
        
        //get page source
        System.out.println(driver.getPageSource().contains("Google"));
        
        driver.quit();//close the browser
       // driver.close();
       // driver.getTitle();
        
  }

}
