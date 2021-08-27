package browser_window_handling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleWithList {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click(); 
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
	    Thread.sleep(2000);
	    
	   Set<String>handles= driver.getWindowHandles();
	   List<String>handlesList=new ArrayList<String>(handles);
	   
	  // String parentWindowId=handlesList.get(0);
	  // String childWindowId1=handlesList.get(1);
	  // String childWindowId2=handlesList.get(2);
	 //  String childWindowId3=handlesList.get(3);
	 //  String childWindowId4=handlesList.get(4);
	   
	  // driver.switchTo().window(childWindowId1);
	 //  System.out.println(driver.getCurrentUrl());
	 //  Thread.sleep(2000);
	 //  driver.close();
	   
	 //  driver.switchTo().window(childWindowId2);
	 //  System.out.println(driver.getCurrentUrl());
	 //  Thread.sleep(2000);
	 //  driver.close();
	   
	  // driver.switchTo().window(childWindowId3);
	 //  System.out.println(driver.getCurrentUrl());
	 //  Thread.sleep(2000);
	 //  driver.close();
	   
	//   driver.switchTo().window(childWindowId4);
	 //  System.out.println(driver.getCurrentUrl());
	 //  Thread.sleep(2000);
	 //  driver.close();
	   
	//   driver.switchTo().window(parentWindowId);
	//   System.out.println(driver.getCurrentUrl());
	//   Thread.sleep(2000);
	 //  driver.close();
	   
	  // for(String e:handlesList) {
		//   driver.switchTo().window(e);
		//   System.out.println(driver.getCurrentUrl());
		//	Thread.sleep(2000);
		//	  driver.close();
	  // }
	   for(int i=handlesList.size()-1;i>=0;i--) {
		   driver.switchTo().window(handlesList.get(i));
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.close();
		   
	   }
	   

	}


	

}
