package xpath_css_sessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Axes_Part2 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

//child to parent---back traversing
//backward traversing is done by /../../../..  or by using  //parent::htmltag
//       //htmltag[@attribute='value']//parent::attribute -->gives immediate parent -- it is always 1 immediate parent
//		 //htmltag[@attribute='value']//ancestor::attribute --> all grandparents ---more than one

//parent to child --- the syntax is  //htmltag[@attribute='value']//child::attribute[@attribute='value']

//sibling traversing--- 1)preceding-sibling  2)following-sibling
// preceding-sibling example- //a[text()='Alex Wonder']//parent::td//preceding-sibling::td/input[@type='checkbox']

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("groupautomation");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(2000);
//driver.findElement(By.xpath("//a[text()='Abe Sabian']//parent::td//preceding-sibling::td/input[@type='checkbox']")).click();
		// selectContact("Abe Sabian");
		// selectContact("Alicia Bario");
		// selectContact("Aliss Jeyhun");
// selectContact("Alex Wonder");	

//clicking on all check boxes of contacts
		//List<WebElement> contactList = driver.findElements(
			//	By.xpath("//tr/td/a[@context='contact']//parent::td//preceding-sibling::td/input[@type='checkbox']"));
		//for (WebElement e : contactList) {
		//	e.click();
		//}
		List<String>contactDetailsOfAS=doGetContactDetails("Abe Sabian");
		System.out.println(contactDetailsOfAS);
		
		List<String>contactDetailsOfAG=doGetContactDetails("Aastha Grover");
		System.out.println(contactDetailsOfAG);
		
		List<String>contactDetailsOfAJ=doGetContactDetails("Aliss Jeyhun");
		System.out.println(contactDetailsOfAJ);
		
		
	}

	public static void selectContact(String name) {
		String checkbox = "//a[text()='" + name + "']//parent::td//preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(checkbox)).click();
	}

	public static List<String> doGetContactDetails(String name) {
		List<String> contactDetails = new ArrayList<String>();
		String phoneNumbers = "//td/a[text()='" + name
				+ "']//parent::td//following-sibling::td//following-sibling::td/span[@context='phone']";
		List<WebElement> contactPhoneNums = driver.findElements(By.xpath(phoneNumbers));
		for (WebElement e : contactPhoneNums) {
			String text = e.getText();
			if (!text.isEmpty()) {
				contactDetails.add(text);
			} 
			//else {
				//contactDetails.add(null);
			//}
		}
		String emailID = "//td/a[text()='" + name + "']//parent::td//following-sibling::td//following-sibling::td/a";
		List<WebElement> emailIds = driver.findElements(By.xpath(emailID));
		for (WebElement e : emailIds) {
			String text1 = e.getText();
			if (!text1.isEmpty()) {
				contactDetails.add(text1);
			} 
			//else {
				//contactDetails.add(null);
			//}
		}
return contactDetails;
	}

}
