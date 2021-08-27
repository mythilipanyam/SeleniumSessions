package popup_handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// to upload the files using send keys method the type should be file in the DOM
		//'type=file' this attribute is mandatory
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		By chooseFileButton=By.name("upfile");
		driver.findElement(chooseFileButton).sendKeys("C:\\Users\\panya\\Desktop\\test doc.docx");

	}

}
