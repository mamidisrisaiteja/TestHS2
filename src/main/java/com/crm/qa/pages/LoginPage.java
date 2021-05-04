package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath="//input[@type='text']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public HomePage login(String un,String pwd) throws Exception {
		Thread.sleep(8000);
		username.sendKeys(un);
		
		password.sendKeys(pwd);
	
		loginBtn.click();
		
		
		return new HomePage();
	}
	
}
