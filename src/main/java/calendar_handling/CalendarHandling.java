package calendar_handling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {
    static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.linkText("OK")).click();
		driver.findElement(By.id("datepicker")).click();
		//driver.findElement(By.xpath("//a[text()='31']")).click();
		
		List<WebElement>daysList=driver.findElements(By.cssSelector("table.ui-datepicker-calendar a"));
		//selectFutureDate("august 2021","4");
		selectPastDate("November 2000","34");
	}
 public static void selectFutureDate(String expMonthYear,String day) {
	 if(Integer.parseInt(day)>31) {
		 System.out.println("Please pass the correct day..");
		 return;
	 }
	 String actMonthYear=driver.findElement(By.cssSelector("div.ui-datepicker-title ")).getText();
	 System.out.println(actMonthYear);
	 while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
		 driver.findElement(By.xpath("//span[text()='Next']")).click();
		 actMonthYear=driver.findElement(By.cssSelector("div.ui-datepicker-title ")).getText();
		 break;
 }
	 
	 driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
 }
 
 
 public static void selectPastDate(String expMonthYear,String day) {
	 if(Integer.parseInt(day)>31) {
		 System.out.println("Please pass the correct day..");
		 return;
	 }
	 String actMonthYear=driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
	 System.out.println(actMonthYear);
	 while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
		 driver.findElement(By.xpath("//span[text()='Prev']")).click();
		 actMonthYear=driver.findElement(By.cssSelector("div.ui-datepicker-title")).getText();
		 
	 }
	 driver.findElement(By.xpath("//a[text()='"+day+"']")).click();
 }
 

}
