package runner_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookTest extends BaseTest {
	
	
	@Test(priority=1)
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("page title is : "+title);
		Assert.assertEquals(title, "Facebook – log in or sign up");	
	}
	
	//enabled=true -- test will be executed
	//enabled=false --test will not be executed
	@Test(priority=2, enabled=false)
	public void pageUrlTest() {
		String pageUrl=driver.getCurrentUrl();
		System.out.println("page url is : "+pageUrl);
		Assert.assertTrue(pageUrl.contains("facebook"));
	}
	
	@Test(priority=3)
	public void searchBoxTest() {
		WebElement emailID=driver.findElement(By.id("email"));
		Assert.assertTrue(emailID.isDisplayed());
	}
	
	
}




