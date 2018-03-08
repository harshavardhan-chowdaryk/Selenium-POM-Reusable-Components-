package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactpage;

	HomePageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		initilizeDriver();

		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 2)
	public void homePageUserLabel() {
		
		TestUtil.switchToFrame();

		String label = homepage.verifyHomeUserLabel();
		AssertJUnit.assertEquals(label, "  User: Naveen K");
	}

	@Test(priority = 1)
	public void contactsLinkTest() {
		TestUtil.switchToFrame();
		contactpage = homepage.clickOnContactsLink();
	}

	
	@AfterMethod
	public void tearDown() {

		driver.close();
	}

}
