package seleniumsessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//For the dropdowns having 'select' html tag, the options can be selected using select class methods.
//There is no default constructor for select class
//we have to pass 'webelement' as an argument
//There are 3 methods of select class
//1.selectByIndex()
//2.selectByVisibleText()
//3.selectByValue()
public class DropDownMethodsWithSelectClass {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By noOfEmployees=By.id("Form_submitForm_NoOfEmployees");
		By industry=By.id("Form_submitForm_Industry");
		By country=By.id("Form_submitForm_Country");
		
	//	Select select=new Select(driver.findElement(noOfEmployees));
	//	Select select1=new Select(driver.findElement(industry));
	//	Select select2=new Select(driver.findElement(country));
		
	//below method selects the options based on the index value-This is preferred for static dropdowns like month list
		//select.selectByIndex(5);
		//select1.selectByIndex(5);
		//select2.selectByIndex(5);
		
	//below method selects the options based on the visible text-This is preferred for dynamic dropdowns where the options keep changing
		//select.selectByVisibleText("16 - 20");
		//select1.selectByVisibleText("Automotive");
		//select2.selectByVisibleText("Angola");
		
	//Below method selects the options based on the value attribute in DOM
		//select.selectByValue("11 - 15");
		//select1.selectByValue("Aerospace");
		//select2.selectByValue("Albania");
		
	//By using generic util methods
		doSelectByVisibleText(noOfEmployees,"16 - 20");
		doSelectByIndex( industry,5);
		doSelectByValue(country,"Albania");
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	
	
	public static void doSelectByVisibleText(By locator,String text) {
		Select select=new Select(getElement( locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectByIndex(By locator,int index) {
		Select select=new Select(getElement( locator));
		select.selectByIndex(index);
	}
	
	public static void doSelectByValue(By locator,String value) {
		Select select=new Select(getElement( locator));
		select.selectByValue(value);
	}

}

