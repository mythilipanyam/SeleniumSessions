package xpath_css_sessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_CSS {
//Cascaded Style Sheet-CSS
//cssSelector is a locator but not an attribute
//cssselector is NOT address of the lement, it just checks the css properties of the elements
//The css syntax is:
//when id is present:  #idvalue or tag#idvalue
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.argos.co.uk/");
		
//when id is present:  #idvalue or tag#idvalue-below example
        //driver.findElement(By.cssSelector("button#consent_prompt_submit")).click();-->tag#idvalue
        //driver.findElement(By.cssSelector("#consent_prompt_submit")).click();//--->#idvalue
		
//when class is present:  .classname or tag.classname
//when multiple classes are present: .class1.class2.class3...classn   or tag.class1.class2.class3...classn
		//driver.findElement(By.cssSelector("button.button.right")).click();-->tag.class1.class2
		driver.findElement(By.cssSelector(".button.right")).click();//-->.class1.class2
		Thread.sleep(3000);
		
//css can also be written using multiple attributes like id and class, the syntax is below. examples below
// 1) .class#id   2)#id.class  3)tag#id.class   4)tag.class#id 

	//driver.findElement(By.cssSelector("._1Rz0y#searchTerm")).sendKeys("Nike");//  .class#id 
	//driver.findElement(By.cssSelector("#searchTerm._1Rz0y")).sendKeys("Nike");// #id.class
		//driver.findElement(By.cssSelector("input._1Rz0y#searchTerm")).sendKeys("Nike");// )tag.class#id 
		//driver.findElement(By.cssSelector("input#searchTerm._1Rz0y")).sendKeys("Nike");//tag#id.class
		
//css by using other attributes: the syntax is:   tag[attribute='value']-example below
		//driver.findElement(By.cssSelector("input[name='searchTerm']")).sendKeys("Nike");
		
//css by using 2 other attributes: the syntax is:   tag[attribute1='value'][attribute2='value']-example below
	//driver.findElement(By.cssSelector("input[name='searchTerm'][placeholder='Search products, brands or FAQs']")).sendKeys("Nike");

		
//contains in css: the syntax is: tag[attribute*='value'] - below example		
		//driver.findElement(By.cssSelector("input[placeholder*='Search products']")).sendKeys("Nike");
		

//starts with in css: the syntax is: tag[attribute^='value'] - below example
		//driver.findElement(By.cssSelector("input[placeholder^='Search']")).sendKeys("Nike");

//starts with and contains in css: the syntax is: tag[attribute1^='value'][attribute2*='value'] - below example
		//driver.findElement(By.cssSelector("input[placeholder*='Search'][name^='search']")).sendKeys("Nike");
		
//ends with in css: tag[attribute$='value']-below example
		//driver.findElement(By.cssSelector("input[placeholder$='FAQs']")).sendKeys("Nike");
		
//parent to child-forward traversing--it is possible in css
//child to parent-backward traversing--it is NOT possible in css
		
//parent to child---> tag[attribute='value'] childattribute ---> gives both direct and indirect child elements-example below
//parent to child---> tag[attribute='value']>childattribute ---> gives directly associated child elements	
		
		
		//List<WebElement>list=driver.findElements(By.cssSelector("[class='Footerstyles__Legal-dqvr2j-13 bKzAii'] a"));
		//for(WebElement e:list) {
			//String text=e.getText();
		//	if(text.equals("Privacy policy")) {
			//	e.click();
		//	}
		//}
		
//  :not keyword in CSS
		//driver.findElement(By.xpath("//span[@class='_2wsKA' and text()='Account']")).click();
		Thread.sleep(3000);
		
//:not keyword in CSS --> :not can be used to exclude one attribute or more than one
//The syntax for morethan one attribute is:  tag.attribute1:not(attribute2value)[attribute3='value']
		driver.findElement(By.cssSelector("input.form-control:not(#current-password)")).sendKeys("mpanyam@gmail.com");
		
		
//comma in css: Multiple webelements can be located at the same time by using comma-example below
By webelementsOnSignInPage=By.cssSelector("input#email-address, input[name='currentPassword'], a[data-bdd-test-id='forgottenPasswordLink']");


// nth-of-type in css: indexing concept in css
By footerLinks=By.cssSelector("div.md-3 li:nth-of-type(1)");

//xpath vs css:
//1.backward traversing not allowed in css
// there is no text() function in css
//

		

	}

}
