package testng_sessions;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest1 extends GlobalClass{
	
	@BeforeClass
	public void getURL() {
		driver.get("https://training-support.net/webelements/login-form/");
	}
	
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		Thread.sleep(1000);
		String text = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(text, "Welcome Back, Admin!");
		
	}
}
