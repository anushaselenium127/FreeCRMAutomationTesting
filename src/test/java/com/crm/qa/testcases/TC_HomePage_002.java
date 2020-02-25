package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.baseclass.Baseclass;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.Dealspage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class TC_HomePage_002 extends Baseclass {

	LoginPage lp;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	Dealspage dealspage;

	public TC_HomePage_002() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		testutil=new TestUtil();
		dealspage=new Dealspage();
		homepage = lp.login(pro.getProperty("username"), pro.getProperty("password"));

	}

	@Test(priority = 1)
	public void verifyhomepageTitle() {
		String homepageTitle = homepage.verifyTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "Homepage totle is not matched");
	}

	@Test(priority = 2)
	public void verifyUsername() {
		testutil.switchtoFrame();
		Assert.assertTrue(homepage.verifyusername());
	}

	@Test(priority = 3)
	public void verifyContactspageLink() {
		testutil.switchtoFrame();
		contactpage = homepage.verifyContactspage();
	}
	
	@Test(priority=4)
	public void verifyDealsPage() {
		testutil.switchtoFrame();
		dealspage=homepage.verifyDealsPage();
	}

	@AfterMethod
	public void teatdown() {
		driver.quit();

	}

}
