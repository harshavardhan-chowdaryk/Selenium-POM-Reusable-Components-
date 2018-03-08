package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;
	String sheetName="contacts";

	ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilizeDriver();

		loginpage = new LoginPage();
		contactpage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
		
	}
	
	@DataProvider
    public Object[][] getCRMTestData()
    {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
		
    }
	
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String frtname, String lstname, String compa){
		homepage.clickOnNewContactLink();
		contactpage.createNewContact(title, frtname, lstname, compa);
	}


}
