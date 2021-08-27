package frames_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCRMProFullRegistration {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(3000);
		driver.switchTo().frame("mainpanel");
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("New Contact")).click();
		
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText("Mrs.");
		
		driver.findElement(By.id("first_name")).sendKeys("Mythili");
		driver.findElement(By.id("middle_initial")).sendKeys("Vajjala");
		driver.findElement(By.id("surname")).sendKeys("Panyam");
		
		Select select1=new Select(driver.findElement(By.name("suffix")));
		select1.selectByVisibleText("PhD");
		
		driver.findElement(By.id("image_file")).sendKeys("C:\\Users\\panya\\Desktop\\test doc.docx");
		
		driver.findElement(By.name("nickname")).sendKeys("Gundodu");
		
		driver.findElement(By.id("company_position")).sendKeys("Active");
		driver.findElement(By.id("department")).sendKeys("Test Team");
		
		Select select3=new Select(driver.findElement(By.id("owner_user_id")));
		select3.selectByVisibleText("2563kitan Pawar (kiranpawar)");
		
		Select select4=new Select(driver.findElement(By.name("category")));
		//Thread.sleep(2000);
		select4.selectByVisibleText("Friend");
		
		Select select5=new Select(driver.findElement(By.name("status")));
		select5.selectByVisibleText("Inactive");
		
		driver.findElement(By.id("phone")).sendKeys("Dont have a phone");
		
		driver.findElement(By.id("mobile")).sendKeys("Dont have a mobile phone");
		
		driver.findElement(By.id("home_phone")).sendKeys("Dont have a home phone");
		
		driver.findElement(By.id("fax")).sendKeys("Dont have a fax number");
		
		driver.findElement(By.id("email")).sendKeys("Dont have an email account");
		
		driver.findElement(By.id("email_alt")).sendKeys("Dont have an alt email account");
		
		driver.findElement(By.xpath("//input[@name='receive_email'][@value='N']")).click();
		
		driver.findElement(By.xpath("//input[@name='receive_sms'][@value='N']")).click();
		
		driver.findElement(By.xpath("//input[@name='allows_call'][@value='N']")).click();
		
		Select select6=new Select(driver.findElement(By.name("im_netowrk")));
		select6.selectByVisibleText("Google Talk");
		
		Select select7=new Select(driver.findElement(By.name("source")));
		select7.selectByVisibleText("Referral");
		
		driver.findElement(By.id("im_id")).sendKeys("Dont have a messenger id");
		
		driver.findElement(By.id("skype_id")).sendKeys("Dont have a skype id");
		
		driver.findElement(By.name("identifier")).sendKeys("Dont have an identifier");
		
		
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
		//validation
		System.out.println(driver.findElement(By.xpath("//td[normalize-space()='Mrs. Mythili Panyam PhD']")).isDisplayed());
		
		
	}

}
