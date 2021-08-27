package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
//Webelements can be located by 8 methods
//1.By.id()-it is always unique and it is of highest priority
//2.By.name()-sometimes can be duplicated, it is of second priority
//3.By.className()-is duplicated most of the time, many elements can have same class name, not preferable to use for find element but can be used for find elements method
//4.By.xpath()-3rd preferance
//5.By.cssSelector()-4th preferance
//6.By.linkText()-used to locate links only
//7.By.partialLinkText()-not preferable and can be used to locate links only
//8.By.tagName()-used to locate the elements by using the tag like h1, h2 etc
	
	
      static WebDriver driver;
      
 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		
	//Locators:Approach:1- the method used is By.id()
		//driver.findElement(By.id("Form_submitForm_FirstName")).sendKeys("Mythili");
		//driver.findElement(By.id("Form_submitForm_LastName")).sendKeys("Panyam");
		
	//Locators:Approach:2- the method used is By.id()
		//WebElement firstName=driver.findElement(By.id("Form_submitForm_FirstName"));
		//WebElement lastName=driver.findElement(By.id("Form_submitForm_LastName"));
		//firstName.sendKeys("Mythili");
		//lastName.sendKeys("Panyam");
		
	//Locators:Approach:3-By.locator returns a 'By'
	    //By first_Name=By.id("Form_submitForm_FirstName");
	    //By last_Name=By.id("Form_submitForm_LastName");
	
	    //WebElement fn=driver.findElement(first_Name);
	    //WebElement ln=driver.findElement(last_Name);
	
	    //fn.sendKeys("Mythili");
	    //ln.sendKeys("Panyam");
		
	//Locators:Approach:4:Generic method-1
		//By first_Name=By.id("Form_submitForm_FirstName");
	    //By last_Name=By.id("Form_submitForm_LastName");
	   //getElement(first_Name).sendKeys("Mythili");
		//getElement(last_Name).sendKeys("Panyam");
		
	//Locators:Approach:5:Generic methods for actions
		//By first_Name=By.id("Form_submitForm_FirstName");
	   // By last_Name=By.id("Form_submitForm_LastName");
		
	//By using By.name()
		//By first_Name=By.name("FirstName");
		//By last_Name=By.name("LastName");
		
	//By using By.className()-not a prefarable methods as multiple elements share same class name
		//By first_Name=By.className("text");
		//By last_Name=By.className("text");
		
	
	//By using By.linkText()
		//By contact_Sales=By.linkText("CONTACT SALES");
		
	//By using By.partialLinkText()
		//By contact_Text=By.partialLinkText("CONTACT");
		//doClick(contact_Text);
		
	//By using By.xpath(): it is a locator, it is 'address of the element', it's not an attribute,
		//By first_Name=By.xpath("//*[@id=\"Form_submitForm_FirstName\"]");    
		//By last_Name= By.xpath("//*[@id=\"Form_submitForm_LastName\"]");
		
	//By using By.cssSelector():it is a locator, it's not an attribute.
	//	By first_Name= By.cssSelector("#Form_submitForm_FirstName");
		//By last_Name= By.cssSelector("#Form_submitForm_LastName");
		     //    doSendKeys(first_Name,"Mythili");
	           //   doSendKeys(last_Name,"Panyam");
	              
	// By using By.tagName()
	    By logo= By.tagName("img");
	    System.out.println(elementDisplay(logo));
	    
	    
	    
	  //Locators:Approach:6:By creating a separate class with all the generic util functions and by creating the object of util class
	    
	//driver.quit();
   }
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();//this method can be used to click on links, buttons, check boxes etc
	}
	
	public static boolean elementDisplay(By locator) {
		return getElement(locator).isDisplayed();
	}
	
}
