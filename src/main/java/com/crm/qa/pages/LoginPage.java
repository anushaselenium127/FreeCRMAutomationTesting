package com.crm.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.baseclass.Baseclass;

public class LoginPage extends Baseclass{
	
    @FindBy(name="username")
    WebElement username;
    
    @FindBy(name="password")
    WebElement password;
    
    @FindBy(xpath="//input[@type='submit']")
    WebElement loginClick;
    
    @FindBy(linkText="Sign Up")
    WebElement signupBtn;
    
    @FindBy(xpath="//img[@class='img-responsive']")
    WebElement logo;
    
    public LoginPage() {
    	
    	PageFactory.initElements(driver,this); //this== LoginPage.class
    }
    
    public String validateLoginPagetitle() {
    	
    	return driver.getTitle();
     
    }
    
    public boolean validateCRMImage() {
    	
    	return logo.isDisplayed();
    }
    
    public HomePage login(String un,String pw) {
    	
    	username.sendKeys(un);
    	password.sendKeys(pw);
    	loginClick.click();
    	
    	return new HomePage();
    	
    }
    
    
    
	
	 
}
