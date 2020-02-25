package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Dealspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TC_ContactPage_003 extends Baseclass {
	
	LoginPage lp;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	Dealspage dealspage;
	String sheetName= "Sheet1";

	
	public TC_ContactPage_003() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		testutil=new TestUtil();
		dealspage=new Dealspage();
		homepage = lp.login(pro.getProperty("username"), pro.getProperty("password"));
		testutil.switchtoFrame();
		contactpage=new ContactPage();

	}
	
	//@Test(priority=1)
	public void verifyContactslabel() {
		
		contactpage=homepage.verifyContactspage();
		Assert.assertTrue(contactpage.verifycontactLabel(),"Contactslabel is missing");
	}
	
	//@Test(priority=2)
	public void verifyselectingContact() {
		contactpage=homepage.verifyContactspage();
		contactpage.selectContactsByName();
	}
	
	@DataProvider
	public Object[][] getCRMdata() {
		
		Object[][] data=TestUtil.gettestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider = "getCRMdata")
	public void validateCreateNewContact(String Title,String FirstName,String Surname,String Company) {
		
		homepage.clickOnNewContact();
		//contactpage.createNewContact("Mr.","Bill", "Keen", "Google");
		contactpage.createNewContact(Title, FirstName, Surname, Company);
		
	}
	
	@AfterMethod
	public void teatdown() {
		driver.quit();

	}


}
