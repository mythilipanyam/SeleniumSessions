package testNGsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	//Pre conditions
	//Test case 1 - test steps + assertions
	//Test case 1 - test steps + assertions
	//Test case 1 - test steps + assertions
	//post conditions
	//The property of '@BeforeMethod' it will get executed every time before the test
	//The property of '@AfterMethod' it will get executed every time after the test
	//The test case execution is based on alphabetical order of the methods
	//The order of execution or lifecycle of testNG execution is as below:
	
	/*
	BeforeSuite: DBConnection
	BeforeTest: createUser
	BeforeClass: launchBrowser
	
	             BeforeMethod: login
                     Test 1: addToCartTest
	             AfterMethod: logout
	             
	             BeforeMethod: login
	                 Test 2: homePageTest
	             AfterMethod: logout
	             
	             BeforeMethod: login
	                 Test 3: paymentsTest
	             AfterMethod: logout
	             
	AfterClass: closeBrowser
	AfterTest: deleteUser
	AfterSuite: disconnectDBConnection
	 */
	
	
	@BeforeSuite
	public void DBConnection() {
		System.out.println("BeforeSuite: DBConnection");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("BeforeTest: createUser");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("BeforeClass: launchBrowser");
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("BeforeMethod: login");
	}
	
	@Test
	public void homePageTest() {
		System.out.println("Test 1: homePageTest");
	}
	
	@Test
	public void addToCartTest() {
		System.out.println("Test 2: addToCartTest");
	}
	
	@Test
	public void paymentsTest() {
		System.out.println("Test 3: paymentsTest");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("AfterMethod: logout");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("AfterClass: closeBrowser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("AfterTest: deleteUser");
	}
	@AfterSuite
	public void disconnectDBConnection() {
		System.out.println("AfterSuite: disconnectDBConnection");
	}
	

}
