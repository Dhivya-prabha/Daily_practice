package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

public class Login {
	ChromeDriver driver;
	 @BeforeClass
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementById("username").sendKeys("Dhivya@testleaf.com");
		driver.findElementById("password").sendKeys("Bluesky@123");
		driver.findElementByCssSelector("input#Login").click();

		Thread.sleep(10000);

		System.out.println(driver.getTitle());
		driver.findElementByClassName("slds-r5").click();
		driver.findElementByXPath("//button[text()='View All']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//p[text()='Sales']").click();
	
/*
		driver.findElementByXPath("(//div[@class='slds-context-bar__label-action slds-p-left--none']//a)[1]").click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[text()='Opportunities']/following::span)[3]"))).click();*/

	}
}