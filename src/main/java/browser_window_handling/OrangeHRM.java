package browser_window_handling;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {
//driver will be initially on parent window
//when we click on some elements then a child window opens
//we have to move the driver from parent window to child window to perform actions on child window
//driver.getWindowHandles() method returns a set of a string
//Set is a collection similar to arraylist
//set doesn't hold duplicate values
//set doesn't store the values according to the indexing
//Set is an index less collection
//Set stores parent window id and child window id in segments
//Set always maintains parent window id at the first segment and child window id at the second segment
//to get the values we have use .iterator() method
// .iterator method returns interator of strings
// .next() method first gives parent window id
// second time it gives child window id
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
	   
	    
	   //opening one child window at a time and closing:
	   // driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
	   // Set<String>handles=driver.getWindowHandles();
	  //  Iterator<String>it=handles.iterator();
	 // String parentWindowId=it.next();//parent window id
	 // String childWindowId=it.next();//child window id
	//  driver.switchTo().window(childWindowId);
	 //System.out.println(driver.getCurrentUrl());
	 // Thread.sleep(2000);
	 // driver.close();//closes the child window, if we use driver.quit, it closes both child and parent windows
	 // driver.switchTo().window(parentWindowId);
	//  System.out.println(driver.getCurrentUrl());
	//  Thread.sleep(2000);
	    
	  //opening one child window at a time and closing:
	 // driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
	  //Set<String>handles1=driver.getWindowHandles();
	  //  Iterator<String>it1=handles1.iterator();
	 // String parentWindowId1=it1.next();//parent window id
	//  String childWindowId1=it1.next();//child window id
	 // driver.switchTo().window(childWindowId1);
	 // System.out.println(driver.getCurrentUrl());
	//  driver.close();//closes the child window, if we use driver.quit, it closes both child and parent windows
	//  driver.switchTo().window(parentWindowId1);
	//  System.out.println(driver.getCurrentUrl());
	    
	    //opening multiple child windows first and then closing:
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click(); 
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
	    Thread.sleep(2000);
	    
	   Set<String>handles= driver.getWindowHandles();
	    Iterator<String> it=handles.iterator();
	   String parentWindowId= it.next();
	   String childWindowId1= it.next();
	   String childWindowId2= it.next();
	   String childWindowId3= it.next();
	   String childWindowId4= it.next();
	   
	   driver.switchTo().window(childWindowId1);
	   System.out.println(driver.getCurrentUrl());
	   Thread.sleep(2000);
	   driver.close();
	   
	   driver.switchTo().window(childWindowId2);
	   System.out.println(driver.getCurrentUrl());
	   Thread.sleep(2000);
	   driver.close();
	   
	   driver.switchTo().window(childWindowId3);
	   System.out.println(driver.getCurrentUrl());
	   Thread.sleep(2000);
	   driver.close();
	   
	   driver.switchTo().window(childWindowId4);
	   System.out.println(driver.getCurrentUrl());
	   Thread.sleep(2000);
	   driver.close();
	   
	   driver.switchTo().window(parentWindowId);
	   System.out.println(driver.getCurrentUrl());
	   Thread.sleep(2000);
	   driver.close();
	   

	}

}
