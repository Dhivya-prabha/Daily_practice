package Basics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {
	public String excelBook;
	public ChromeDriver driver;

	@Parameters({"url", "uname", "pwd"})
	@BeforeMethod
	public void login(String url, String uname, String pass) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(uname);
		driver.findElementById("password").sendKeys(pass);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		driver.close();	

	}
	@DataProvider(name="fetchdata")																						
	public String[][] sendData() throws IOException {
		
		String[][] array = readExcel.excelData(excelBook);
		return array;
		//return readExcel.excelData(excelBook);
		
		/*String[][] array = new String [2][3];
		array[0][0] = "Testleaf";
		array[0][1] = "Balaji";
		array[0][2] = "C";
		
		array[1][0] = "Testleaf";
		array[1][1] = "Dhivya";
		array[1][2] = "Prabha";*/
	    }
}
