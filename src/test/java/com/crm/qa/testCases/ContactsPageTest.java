package com.crm.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	String fName="jasmitha";
	
	
	String sheetName="contacts";
	
	public ContactsPageTest() {
		super();
	}
@BeforeMethod
public void setUp() throws Exception {
	initialization();
	Thread.sleep(10000);
	loginPage=new LoginPage();
	Thread.sleep(10000);
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(3000);
	contactsPage=homePage.navigateToContactsPage();
}

@Test(enabled=false)
public void validateContactsLabelDisplay() {
	Assert.assertTrue(contactsPage.contactsLabelDisplay(),"contacts label is missing");
}

@DataProvider
public Object[][] getData() throws Exception{
	Object[][] data=TestUtil.getExcelData(sheetName);
	return data;
}
//(dataProvider="getData")

@Test(priority=2,dataProvider="getData")
public void addContacts(String fName,String lName,String email) throws Exception {
	
	contactsPage.createNewContact(fName, lName, email);
	
}

@AfterMethod
public void endUp() {
	driver.quit();
}


}
