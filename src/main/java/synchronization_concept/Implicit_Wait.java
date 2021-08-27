package synchronization_concept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicit_Wait {
    static WebDriver driver;
	public static void main(String[] args) {
//There are two types of waits in selenium
// 1. static waits : Thread.sleep(10000) --> comes from Java - this wait pauses thes cript for 10 secs 
//even though the element is found after 3 secs
// 2.dynamic waits: implicit and explicit--10 secs--if the element is found in 3 secs, remaining 7secs will be ignored 
//and script will get executed		
//explicit wait:WebDriverWait(class) internally extends FluentWait(class) which implements Wait interface
//implicit wait:
// 1.Its dynamic wait
// 2. It is only applicable for WebElements
// 3.It is not applicable for nonwebelements (urls, titles,alerts pop up etc)
// 4.It is a global wait-applied with driver-applied for all upcoming webelements
//when implicit wait is added in the script, it is applied for all the webelements even where it is not required
//thus impacting the performance of the script
//For every webpage, the implicit wait needs to be over rided or changed
//Implicit wait is not preferred to use as it affects the performance of the script
//Implicit wait gives 'NuSuchElementException' when the webelement is not found withinthe time
		
WebDriverManager.chromedriver().setup();
  driver=new ChromeDriver();
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);//this is the syntax of the implicit wait
  
	}

}
