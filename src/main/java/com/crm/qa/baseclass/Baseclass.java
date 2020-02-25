package com.crm.qa.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.crm.qa.util.webEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties pro;
	static webEventListener eventListener;
	static EventFiringWebDriver eDriver;
	
	
	public static void initialization() {
		
		String browsername=pro.getProperty("browser");
		
		if(browsername.equals("chrome")) {
			
			  WebDriverManager.chromedriver().clearPreferences();
		      WebDriverManager.chromedriver().setup();
		      driver = new ChromeDriver();
		
		}
		else if(browsername.equals("firefox")) {
			
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
		}
		
		eDriver=new EventFiringWebDriver(driver);
		eventListener=new webEventListener();
		eDriver.register(eventListener);
		driver=eDriver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(pro.getProperty("url"));
	}
	
	
	
	public Baseclass() {
		
		pro=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:/Users/arjun/eclipse-workspace/FreeCRMAutomationTesting/src/main/java/com/crm/qa/config/config.properties");
			pro.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
