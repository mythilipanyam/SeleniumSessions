package runner_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
	
	
	@Test(priority=1)
	public void pageTitleTest() {
		String title=driver.getTitle();
		System.out.println("page title is : "+title);
		Assert.assertEquals(title, "Google");	
	}
	
	@Test(priority=2)
	public void pageUrlTest() {
		String pageUrl=driver.getCurrentUrl();
		System.out.println("page url is : "+pageUrl);
		Assert.assertTrue(pageUrl.contains("google"));
	}
	
	@Test(priority=3)
	public void searchBoxTest() {
		WebElement searchBar=driver.findElement(By.xpath("//input[@name='q']"));
		Assert.assertTrue(searchBar.isDisplayed());
	}
	
	
}




