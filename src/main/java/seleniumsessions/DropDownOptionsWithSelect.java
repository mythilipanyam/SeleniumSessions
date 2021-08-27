package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//getOptions() method returns list of webelements
public class DropDownOptionsWithSelect {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		By noOfEmployees = By.id("Form_submitForm_NoOfEmployees");
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");

		//Select select = new Select(driver.findElement(industry));
	//	List<WebElement> indusList = select.getOptions();
		//System.out.println(indusList.size());
	//	for (WebElement e : indusList) {
		//	System.out.println(e.getText());
		//}
		List<String>noofemployeeslist=doGetDropDownOptionsList(noOfEmployees);
		List<String>industrylist=doGetDropDownOptionsList(industry);
		List<String>countrylist=doGetDropDownOptionsList(country);
		
		//validation points
		if(industrylist.size()==21) {
			System.out.println("Pass");
		}
		if(countrylist.contains("India")) {
			System.out.println("Pass");
		}
		doSelectOptionFromList(country,"India");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static List<String> doGetDropDownOptionsList(By locator) {
		List<String>optionsValList=new ArrayList<String>();
		Select select=new Select(getElement(locator));
		List<WebElement>optionsList=select.getOptions();
		
		System.out.println(optionsList.size());
		
		for(WebElement e:optionsList) {
		String text=e.getText();
		optionsValList.add(text);
		}
		return optionsValList;
	}
	
	public static void doSelectOptionFromList(By locator,String value) {
		Select select=new Select(getElement(locator));
		List<WebElement>optionsList=select.getOptions();
		
		System.out.println(optionsList.size());
		
		for(WebElement e:optionsList) {
		String text=e.getText();
		if(text.equals(value)) {
			e.click();
			break;
		}
		
		}
	}


}
