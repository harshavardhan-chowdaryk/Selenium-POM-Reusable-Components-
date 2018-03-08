package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	public LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilizeDriver();
		loginpage = new LoginPage();

	}

	@AfterMethod
	public void tearDown() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {

		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.validateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest(){
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

}
