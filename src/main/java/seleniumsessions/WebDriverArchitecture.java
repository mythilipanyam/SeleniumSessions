package seleniumsessions;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverArchitecture {
	
//Search Context is the Parent Interface of WebDriver Interface
//Search Context has 2 methods-'findelement' method and 'findelements' method
//During the diagrammatic repreentation of interface and class-interface is always represented as a rectangle
// and class is represented as a circle
//WebDriver interface uses extends keyword to inherit the methods of search contect
//'Remotewebdriver' class is the child class of webdriver interface
//remotewebdriver class uses implements keyword to inherit the properties of webdriver interface	
//'Safaridriver','firefoxdriver','operadriver','edgedriver' etc are the child classes of remotewebdriver class
//'Safaridriver','firefoxdriver','operadriver','edgedriver' etc use extends keyword to inherit the properties of remotewebdriver class
//'chromedriver' is the grandchild of remotewebdriver class
//'chromedriver' is the child class of chromiumdriver  class-uses extends keyword	
//chromiumdriver class is the child class of remotewebdriver class-uses extends keyword
//all the webbrowser drivers like saridriver, firefoxdriver,chromedriver etc do not have any individual methods	
//If there were any individual methods in webbrowserdrivers, these methods will not be accessibile by webdriver.driver
//grandparent interface reference variable would not have access to grandchild methods because of 'reference type check' 	
//thats why there aren't any individual methods of webbrowserdriver classes
	
	//the below method is only useful for launching chromedriver, not suitable for crossbrowser testing
      // ChromeDriver driver=new ChromeDriver();
	
	//The below method is suitable for cross browser testing
	    //WebDriver driver= new ChromeDriver();
	    //WebDriver driver= new FirefoxDriver();
	    //WebDriver driver= new EdgeDriver();
	    //WebDriver driver= new SafariDriver();
	
	//The below method is suitable for cross browser testing
        //RemoteWebDriver driver= new ChromeDriver();
        //RemoteWebDriver driver= new FirefoxDriver();
        //RemoteWebDriver driver= new EdgeDriver();
        //RemoteWebDriver driver= new SafariDriver();
	
	public static void main(String[] args) {
 //With the below topcasting, only methods of searchcontext interface can be accessed
	 // SearchContext driver=new ChromeDriver();
		
		
//Topcasting between WebDriver and RemoteWebDriver
//the below ctopcasting is used only the test script execution is on remote machines like docker,cloud,selenium grid etc
     //WebDriver driver=new RemoteWebDriver(remoteAddress, capabilities);
		
	System.out.println("All the WebDriver Architecture documentstion can be found at \"https://github.com/seleniumhq/selenium\"");
		
}
	
}
