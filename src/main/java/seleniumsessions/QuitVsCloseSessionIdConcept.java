package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsCloseSessionIdConcept {
// client and server communication is through session id
//	starting from launching browser to quit or closing the browser-the session id remains same
//	when quit() method is used the session id becomes null after the browser is quit
//	when close() method is used the session id becomes invalid or expired after the browser is closed
//	when we try to run driver.get() method after quit() method- We will get 'NoSuchSessionException: Session ID is null'
//	when we try to run driver.get() method after close() method- We will get'NoSuchSessionException: invalid session id'
//	when we try to run driver.get() method after close() method, the session id will be still there but it is invalid
// To solve the problem-we need to relaunch the browser-a new session id will be created
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\panya\\Downloads\\chromedriver_win32\\chromedriver.exe");	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.Google.com");
    System.out.println(driver.getTitle());
    
    System.out.println(driver.getCurrentUrl());
    
    System.out.println(driver.getPageSource().contains("Google"));
    
   driver.quit();
    //driver.close();
   System.out.println(driver.getTitle());//NoSuchSessionException
}

}
