package xpath_css_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath_Custom_Part1 {
	
//when using By.classname() method only one unique class should be used, multiple class names are not allowed
//but in xpath multiple class names are allowed with spaces inbetween the class names
//in css selector, multiple class names are allowed by using a . after each class name
	
//xpath-address of an element in HTML DOm
//There are two types of xpath
//absolute xpath and relative xpath
//absolute xpath -starts with single slash and starts from the top of the HTML Dom and traverses bottom to the element
//relative xpath or custom xpath
//The syntax for the relative xpath is:
//              //htmltag[@attribute='value']
	

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// to upload the files using send keys method the type should be file in the DOM
		//'type=file' this attribute is mandatory
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.thebodyshop.com/en-gb/");
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(3000);
		//The syntax for the relative xpath is:
		
//    //htmltag[@attribute='value']-example below-with one attribute
	//driver.findElement(By.xpath("//cx-custom-icon[@name='wishlist']")).click();
		
// //htmltag[@attribute1='value' and @attribute2='value']-example below-with two attributes-either 'and' or 'or' can be used
	//driver.findElement(By.xpath("//a[@href='https://www.facebook.com/TheBodyShopUK/' and @title='facebook']")).click();
	//driver.findElement(By.xpath("//a[@href='https://www.facebook.com/TheBodyShopUK/' or @title='facebook']")).click();	
		
//  (//htmltag[@attribute='value'])[index]-example below, here index is position of the element
	//driver.findElement(By.xpath("(//div[@class='icon icon--white-dynamic icon--white-dynamic--header'])[3]")).click();
//driver.findElement(By.xpath("(//div[@class='icon icon--white-dynamic icon--white-dynamic--header'])[position()=3]")).click();
//driver.findElement(By.xpath("(//span[@class='depth-1'])[last()]")).click();-goes to the last element in a group of elements


// By.tagName("a")-gives total number of links on a page
// By.xpath("//a")-gives total number of links on a page
		
		
		//xpath with text() function-syntax is: //htmltag[text()='value']---below example
 //driver.findElement(By.xpath("//span[text()='About us']")).click();
	//Thread.sleep(2000);
		
		//xpath with contains() function: the syntax is below: It can be used with an attribute and with text() function
// -first syntax is: //htmltag[contains(@attribute,'value'] -example below
		//System.out.println(driver.findElement(By.xpath("//h1[contains(@aria-label,'ABOUT')]")).isDisplayed());	
		
//second syntax is: //htmltag[contains(text(),'value']  -example below
	//System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'ABOUT')]")).isDisplayed());
		
		driver.findElement(By.xpath("//span[text()='Join us']")).click();
		Thread.sleep(2000);
		
		
//xpath with contains() with two attributes
//syntax is: //htmltag[contains(@attribute1,'value') and attribute2='value'] ----below example
	//System.out.println(driver.findElement(By.xpath("//h1[contains(@aria-label,'Love Your') and @role='heading']")).isDisplayed());
		

//xpath with contains() with three attributes
System.out.println(driver.findElement(By.xpath("//h1[contains(@aria-label,'Love Your') and @role='heading' and contains(text(),'Love Your Body')]")).isDisplayed());

//xpath with contains text() function and attribute
//syntax is:   //htmltag[contains(text(),'value') and @attribute='value']

//xpath with contains text() function and contains attribute value
//syntax is:   //htmltag[contains(text(),'value') and contains(@attribute,'value')]

//xpath with starts-with() function:useful for dynamic elements with dynamic values
//Syntax is  //htmltag[starts-with(@attribute,'value')]
//for example below:
//<input id="firstname_123"
//<input id="firstname_234"
//<input id="firstname_456"

//The xpath for the above example where the value is dynamic is
//   //input[starts-with(@id,'firstname_')]


//   //*[@attribute='value']  ---> this method searches the entire dom and locates all the elements where attribute=value 
//    //htmltag[@attribute='value'] ----> this method searches the dom and locates the elements where htmltag and attaribute are matched





}}
