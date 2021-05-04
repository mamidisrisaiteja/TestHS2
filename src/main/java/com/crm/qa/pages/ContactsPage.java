package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement newBtn;
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//div[@class='three fields']//div[@class='ui field']//div[@class='ui right corner labeled input']//input[@type='text']")
	WebElement emaiId;
	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveBtn;
	
	@FindBy(xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement firstName;
	
	//tst
	
	@FindBy(xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui form segment custom-form-container']/div[2]/div[1]/div[1]/div[1]/input[1]")
	WebElement lastName;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLabelDisplay() {
		
		return contactsLabel.isDisplayed();
		
	}
	
	
	public void createNewContact(String fName,String lName,String email) throws Exception {
		Thread.sleep(2000);
		newBtn.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		emaiId.sendKeys(email);
		Thread.sleep(2000);
		saveBtn.click();
		Thread.sleep(5000);
	}

}
