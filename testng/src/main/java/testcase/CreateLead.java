package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Basics.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods {
	@BeforeTest
	public void sendExcel() {
		excelBook = "CreateLead"; 
	}
	@Test(dataProvider="fetchdata")
	public void runCreatelead(String Cname, String Fname, String Lname) {
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(Cname);
		driver.findElementById("createLeadForm_firstName").sendKeys(Fname);
		driver.findElementById("createLeadForm_lastName").sendKeys(Lname);
		driver.findElementByName("submitButton").click();
	}
	
}
