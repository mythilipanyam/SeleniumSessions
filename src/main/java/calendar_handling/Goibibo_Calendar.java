package calendar_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_Calendar {
    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.id("departureCalendar")).click();
		Thread.sleep(3000);
		selectDepartureDate("November 2022", "22");

	}
	public static void  selectDepartureDate(String expMonthYear, String day) {
		if(Integer.parseInt(day)>31) {
			System.out.println("Please pass the correct date...");
			return;
		}
		String actMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		while(!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			driver.findElement(By.cssSelector("span.DayPicker-NavButton.DayPicker-NavButton--next")).click();
			actMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		}
		driver.findElement(By.xpath("//div[text()='"+day+"']")).click();
	}

}
