package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.Baseclass;

public class HomePage extends Baseclass {
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")
    WebElement userName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslnk;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactlnk;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslnk;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement taskslnk;
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
		
	}
	
	public String verifyTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyusername() {
		
		return userName.isDisplayed();
	}
	
	public ContactPage verifyContactspage() {
		//Actions action=new Actions(driver);
		//action.click(contactslnk).build().perform();
		contactslnk.click();
		return new ContactPage();
	}
	
	public Dealspage verifyDealsPage() {
		
		dealslnk.click();
		return new Dealspage();
	}
	
	public TaskPage verifytaskPage() {
		
		taskslnk.click();
		return new TaskPage();
	}
	
	public void clickOnNewContact()  {
		
		Actions action=new Actions(driver);
				
		action.moveToElement(contactslnk).moveToElement(newContactlnk).click().build().perform();
		
		//newContactslnk.click();
		//action.moveToElement(newContactslnk).click().build().perform();		
				
				;
	}
	
	
}

