package com.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cognizant1.Testng.LoginPageClass;

public class LoginTest {
	
	WebDriver driver = new EdgeDriver();
	
	LoginPageClass pageClass = new LoginPageClass(driver);
	
	@Test
	public void loginTest() throws InterruptedException {
		pageClass.enterUsername("admin");
		pageClass.enterPassword("password");
		pageClass.clickBrn();
		Thread.sleep(2000);

		Assert.assertEquals(driver.getTitle(), "Selenium: Login Success!");
	}
}
