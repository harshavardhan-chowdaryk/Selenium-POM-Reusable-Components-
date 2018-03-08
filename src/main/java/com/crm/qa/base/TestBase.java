package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/crm/qa/config/config.properties");
				prop.load(fis);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

	public void initilizeDriver() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/kavurichowdary/Desktop/Harsha1/Selenium Project/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"/Users/kavurichowdary/Desktop/Harsha1/Selenium Project/geckodriver");
			driver = new FirefoxDriver();

		}
		  EventFiringWebDriver e_driver=new EventFiringWebDriver(driver);
		  WebEventListner listner=new WebEventListner();
		  e_driver.register(listner);
		  driver=e_driver;
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
