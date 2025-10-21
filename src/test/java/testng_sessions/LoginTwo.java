package testng_sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerClass.class)
public class LoginTwo extends BaseClass{
	
	@Test
	public void loginTest() {
		WebElement uname = driver.findElement(By.id("username"));
		uname.sendKeys("admin2");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
		String targetText = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(targetText, "Welcome Back, Admin!");
		
	}
	
	@Test
	public void sample() {
		Assert.assertEquals(false, false);
	}
}
