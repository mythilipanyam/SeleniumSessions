package runner_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.ErrorMessages;

public class AmazonTest extends BaseTest{
//In the runner class,xml file, verbose keyword is maintained
//verbose is for maintaining the logs on the console
//the value of verbose can vary from 1 to 10
//verbose=1 gives minimum logs about the test
//verbose=10 gives heavy logs about the test

//enabled=true -- test will be executed
//enabled=false --test will not be executed
//By default, all he tests are enabled=true only
	
	
	@Test
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("page title is : "+title);
		Assert.assertEquals(title, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more",ErrorMessages.TITLE_MISMATCHEDMESSAGE);	
	}
	
	@Test
	public void pageUrlTest() {
		String pageUrl=driver.getCurrentUrl();
		System.out.println("page url is : "+pageUrl);
		Assert.assertTrue(pageUrl.contains("amazon"),ErrorMessages.URL_DOESNOTCONTAINMESSAGE);
	}
	
	@Test
	public void searchBoxTest() {
		WebElement searchBar=driver.findElement(By.id("twotabsearchtextbox"));
		Assert.assertTrue(searchBar.isDisplayed(),ErrorMessages.SEARCHBAR_NOTDISPLAYEDMESSAGE);
	}
	
	
}



