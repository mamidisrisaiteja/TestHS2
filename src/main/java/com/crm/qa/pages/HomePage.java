package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//i[@class='users icon']")
    WebElement contactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public ContactsPage navigateToContactsPage() throws Exception {
		Thread.sleep(3000);
		contactsLink.click();
		
		return new ContactsPage();
		
	}
}
