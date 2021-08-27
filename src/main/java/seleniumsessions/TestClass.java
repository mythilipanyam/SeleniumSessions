package seleniumsessions;

import org.openqa.selenium.WebDriver;

//Assertions or validations should never be written inside the util classes, only methods and business logic should be written inside the util class
//validations or assertions should always be written inside the test execution class
public class TestClass {

	public static void main(String[] args) {
		
		BasicUtilClass util=new BasicUtilClass();
		
		WebDriver driver = util.launchingBrowser("edge");
		
	     util.launchUrl("https://www.amazon.co.uk/");
	     
		System.out.println(util.getCurrentPageUrl());
		
		util.getPageTitle();
		System.out.println("current page title is: "+util.getPageTitle());
		//validation
		if(util.getPageTitle().contains("Amazon")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("incorrect title");
		}
		
		util.closeBrowser();

	}

}
