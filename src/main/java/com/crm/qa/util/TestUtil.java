package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static Object[][] data;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public static Object[][] getExcelData(String sheetName) throws IOException {
		File f=new File("C:\\Users\\saitejamamidi\\eclipse-workspace\\SelFinal24Nov2020\\src\\main\\java\\com\\crm\\qa\\testdata\\ContactsUpload.xlsx");
		
		FileInputStream fip=new FileInputStream(f);
		
		workbook=new XSSFWorkbook(fip);
		
	    sheet=workbook.getSheet(sheetName);
	    data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	    for(int i=0;i<sheet.getLastRowNum();i++) {
	    	for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
	    			    	  
	    	 data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	    			 
	    }
	}
	   
	   
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileHandler.copy(src, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
