package utils_concept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMAppTest {

	public static void main(String[] args) {
		
		String browser="chrome";
		BrowserUtil brUtil=new BrowserUtil();
		WebDriver driver=brUtil.launchingBrowser("chrome");
		brUtil.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		System.out.println(brUtil.getCurrentPageUrl());
		System.out.println(brUtil.getPageTitle());
		
		//By locators
		By first_Name=By.id("Form_submitForm_FirstName");
	    By last_Name=By.id("Form_submitForm_LastName");
	    By email=By.id("Form_submitForm_Email");
	    By job_Title=By.id("Form_submitForm_JobTitle");
	    By company_Name=By.id("Form_submitForm_CompanyName");
	    By phone_Number=By.id("Form_submitForm_Contact");
	    
		ElementUtil eleUtil=new ElementUtil(driver);
		eleUtil.doSendKeys(first_Name,"Mythili");
		eleUtil.doSendKeys(last_Name,"Panyam");
		eleUtil.doSendKeys(email, "mpanyam@gmail.com");
		eleUtil.doSendKeys(job_Title,"Test Analyst");
		eleUtil.doSendKeys(company_Name, "ECC");
		eleUtil.doSendKeys(phone_Number, "07777777777");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		brUtil.quitBrowser();

	}

}
