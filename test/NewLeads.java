package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class NewLeads extends Login {
@Test
	public void runLeads() {

		driver.findElementByXPath("(//div[@class='slds-context-bar__label-action slds-p-left--none']//a)[2]").click();
		
		WebElement element = driver.findElementByXPath("//span[text()='New Lead']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		driver.findElementByXPath("(//div[@class='uiPopupTrigger']//a)[1]").click();
		driver.findElementByXPath("//a[@title='Mr.']").click();
		String name= "David";
		driver.findElementByXPath("//input[contains(@class,'lastName compoundBLRadius')]").sendKeys(name);
		driver.findElementByXPath("(//div[contains(@class,'uiInput uiInputText')]//input)[3]").sendKeys("Google");
		driver.findElementByXPath("//span[text()='Save']").click();
		driver.findElementByXPath("//li[@title='Details']").click();
		String text = driver.findElementByXPath("//slot[@slot='outputField']/lightning-formatted-name").getText();
		System.out.println(text);
		if(text.contains(name))
		{
			System.out.println("Lead created Successfully");
		}
		
	}
}