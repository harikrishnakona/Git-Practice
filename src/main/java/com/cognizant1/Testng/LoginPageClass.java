package com.cognizant1.Testng;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageClass {
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement usernameFieldElement;
	
	@FindBy(id = "password")
	WebElement passwordFieldElement;
	
	@FindBy(xpath = "//button[text() = 'Submit']")
	WebElement btnElement;
	
	public LoginPageClass(WebDriver driver) {
	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterUsername(String name) {
		driver.get("https://training-support.net/webelements/login-form");
		usernameFieldElement.sendKeys(name);
	}
	
	public void enterPassword(String password) {
		passwordFieldElement.sendKeys(password);
	}
	
	public void clickBrn() {
		btnElement.click();
	}
	
}
