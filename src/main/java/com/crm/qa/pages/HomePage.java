package com.crm.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
	WebElement usernameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newcontactsLink;


	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomeUserLabel() {
		return usernameLable.getText();
	}
	
	public String verifyHomeTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		dealsLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions act =new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newcontactsLink.click();
		
	}


}
