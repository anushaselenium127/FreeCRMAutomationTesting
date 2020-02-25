package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.baseclass.Baseclass;

public class TestUtil extends Baseclass {
	
	public static long PAGE_TIME_LOAD = 20;
	public static long IMPLICIT_TIME = 10;
	public static String filepath="C:\\Users\\arjun\\eclipse-workspace\\FreeCRMAutomationTesting\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public void switchtoFrame() {
		driver.switchTo().frame("mainpanel");
		
	}
	
	public static Object[][] gettestData(String sheetName) {
		FileInputStream file= null;
		try {
			 file=new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
		
	}
	
	public static void getScreenshot() throws IOException {
		
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String CurrDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcFile, new File(CurrDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
		
		
	}

}
