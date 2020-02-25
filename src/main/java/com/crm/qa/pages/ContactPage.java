package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.baseclass.Baseclass;

public class ContactPage extends Baseclass {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslnk;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactlnk;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement surname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='title']")
	WebElement selecttitle;

	
	public ContactPage() {
       PageFactory.initElements(driver,this);		
	}
	
	public boolean verifycontactLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName() {
		driver.findElement(By.xpath("//tr[6]//td//input")).click();
		
	}
	
	
	public void createNewContact(String title,String fn, String sn, String comp) {
		
		Select select=new Select(selecttitle);
	    
		select.selectByVisibleText(title);
		firstname.sendKeys(fn);
		surname.sendKeys(sn);
		company.sendKeys(comp);
		//saveBtn.click();
		
	}
	
	
}
