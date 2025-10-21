package testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TrainingSupport {
	WebDriver driver;
	String urlString = "https://training-support.net/";
	
	@BeforeClass
	public void setUpDriver() {
		driver = new ChromeDriver();
		driver.get(urlString);
	}
	
	@Test
	public void clickOnDropdown() {
		WebElement button = driver.findElement(By.xpath("//button[1]"));
		button.click();
		
		WebElement element = driver.findElement(By.xpath("//a[text()='WebElements']"));
		Assert.assertTrue(element.isDisplayed());
		
		element.click();
	}
	
	@Test(dependsOnMethods = {"clickOnDropdown"})
	public void openLogin() throws InterruptedException {
		
		Thread.sleep(1000);
		
		WebElement login = driver.findElement(By.xpath("//span[text()='Login Form']/parent::a"));
		login.click();
		
		Thread.sleep(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://training-support.net/webelements/login-form/");
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
}
