package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TC_LoginPage_001 extends Baseclass {
	
	LoginPage lp;
	HomePage homepage;
	public TC_LoginPage_001() {
		
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		
		    initialization();
		     lp=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title=lp.validateLoginPagetitle();
		System.out.println(lp.validateLoginPagetitle());
		String expTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(title, expTitle);
       		
	}
	
	@Test(priority=2)
	public void logoTest() {
		
		boolean image=lp.validateCRMImage();
		Assert.assertTrue(image);
	}
	
	@Test(priority=3)
	public void logintest() {
		
		homepage=lp.login(pro.getProperty("username"), pro.getProperty("password"));
		
	}
	
	
	@AfterMethod()
	public void teardown() {
			
			driver.quit();
		
	}

}
