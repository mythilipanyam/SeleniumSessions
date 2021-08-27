package utils_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenCartRegistrationTest {

	public static void main(String[] args) {
		
		String browser="firefox";
		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver=brUtil.launchingBrowser(browser);
		brUtil.launchUrl("https://demo.opencart.com/index.php?route=account/register");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getCurrentPageUrl());
		
		//By locators
		By first_Name=By.id("input-firstname");
		By last_Name=By.id("input-lastname");
		By email=By.id("input-email");
		By phone_Number=By.id("input-telephone");
		By password=By.id("input-password");
		By confirm_Password=By.id("input-confirm");
		
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendKeys(first_Name, "Mythili");
		eleUtil.doSendKeys(last_Name, "Panyam");
		eleUtil.doSendKeys(email, "mpanyam@gmail.com");
		eleUtil.doSendKeys(phone_Number, "07777777777");
		eleUtil.doSendKeys(password, "Test123");
		eleUtil.doSendKeys(confirm_Password, "Test123");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		brUtil.quitBrowser();

	}

}
