package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpLink;

	@FindBy(xpath = "//a[contains(@class,'navbar-brand')]")
	WebElement freeCrmLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ++++++++++++++++++++ACTIONS++++++++++++++++++++++
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	public boolean validateCRMlogo() {

		return freeCrmLogo.isDisplayed();
	}

	public HomePage login(String uname, String pword) {
		username.sendKeys(uname);
		password.sendKeys(pword);
		//loginbtn.click();
		
	JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", loginbtn);
		
    	return new HomePage();

	}

}
