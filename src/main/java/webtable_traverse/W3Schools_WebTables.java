package webtable_traverse;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3Schools_WebTables {
      static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
    //  //table[@id="customers"]/tbody/tr[2]/td[1] -- xpath of first company
	//  //table[@id="customers"]/tbody/tr[3]/td[1] -- xpath of second company
	//  //table[@id="customers"]/tbody/tr[4]/td[1] -- xpath of third company
	//  //table[@id="customers"]/tbody/tr[5]/td[1] -- xpath of fourth company
	//  //table[@id="customers"]/tbody/tr[6]/td[1] -- xpath of fifth company
	//  //table[@id="customers"]/tbody/tr[7]/td[1] -- xpath of sixth company
		
		//xpath breaking concept:
		
		//String beforeXpath="//table[@id=\"customers\"]/tbody/tr[";
		//String afterXpath="]/td[1]";
		
	//	int rowCount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		
		//printing company list
		//for(int i=2;i<=rowCount;i++) {
		//	String fullxpath=beforeXpath+i+afterXpath;
		//	String companyList=driver.findElement(By.xpath(fullxpath)).getText();
		//	System.out.println(companyList);
		//	}
	//System.out.println("----------------------------------------------------------------");	
		//Printing Contact list
		//String beforeXpath1="//table[@id=\"customers\"]/tbody/tr[";
		//String afterXpath1="]/td[2]";
		//for(int i=2;i<=rowCount;i++) {
			//String fullxpath1=beforeXpath1+i+afterXpath1;
			//String contactList=driver.findElement(By.xpath(fullxpath1)).getText();
			//System.out.println(contactList);
		//	}
	//System.out.println("----------------------------------------------------------------------");	
		//Printing Country list
				//String beforeXpath2="//table[@id=\"customers\"]/tbody/tr[";
				//String afterXpath2="]/td[3]";
				//for(int i=2;i<=rowCount;i++) {
				//	String fullxpath2=beforeXpath2+i+afterXpath2;
				//	String countryList=driver.findElement(By.xpath(fullxpath2)).getText();
				//	System.out.println(countryList);
				//	}
		
		webTableContentPrinting(1);
	System.out.println("----------------------------------------------------------------");	
		webTableContentPrinting(2);
	System.out.println("----------------------------------------------------------------");	
		webTableContentPrinting(3);
	System.out.println("----------------------------------------------------------------");	
	   entireWebTablePrinting();
	}
	
	public static void webTableContentPrinting(int columnNumber) {
		int rowCount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		String beforeXpath="//table[@id=\"customers\"]/tbody/tr[";
		String afterXpath="]/td["+columnNumber+"]";
		for(int i=2;i<=rowCount;i++) {
			String fullxpath=beforeXpath+i+afterXpath;
			String columnList=driver.findElement(By.xpath(fullxpath)).getText();
			System.out.println(columnList);
			}
		
	}
	public static void entireWebTablePrinting() {
		List<WebElement> rowsCount=driver.findElements(By.xpath("//table[@id='customers']//tr"));
	    List<WebElement>columnsCount=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td"));
	    String firstHalf="//table[@id='customers']/tbody/tr[";
	    String secondHalf="]/td[";
	    String thirdHalf="]";
			for(int i=2;i<=rowsCount.size();i++) {
				for(int j=1;j<=columnsCount.size();j++) {
					String fullxpath=firstHalf+i+secondHalf+j+thirdHalf;
					String cellText=driver.findElement(By.xpath(fullxpath)).getText();
					System.out.print(cellText);
				}
				System.out.println();
			}
		}
	}


