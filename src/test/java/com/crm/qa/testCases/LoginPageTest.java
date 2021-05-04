package com.crm.qa.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
public LoginPageTest() {
	super();
}
@BeforeMethod
public void setUp() throws Exception {
	initialization();
	Thread.sleep(5000);
	loginPage=new LoginPage();
	
}


@Test(priority=1)
public void loginPageTitleTest() {
	
	String title=loginPage.validateLoginPageTitle();
	System.out.println(title);
	Assert.assertEquals(title,"Cogmento CRM");
	
}

@Test(priority=2)
public void loginTest() throws Exception {
	Thread.sleep(5000);
	homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(5000);
}

@AfterMethod
public void endUp() throws Exception {
	Thread.sleep(3000);
	driver.quit();
	
}

}
