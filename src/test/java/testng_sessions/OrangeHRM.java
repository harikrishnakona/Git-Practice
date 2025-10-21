package testng_sessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUpDriver() {
		driver = new ChromeDriver();
		System.out.println("Setting the driver");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Test
	public void login() {
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys("Admin");
 
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));;
		password.sendKeys("admin123");
		
		WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
		loginButton.click();
		
//		Assert.fail();
//		Correct Url
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

//		Incorrect url
//		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
	}
	
	@Test(dependsOnMethods = {"login"})
	public void getAdmin() {
		WebElement admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
		admin.click();
//		Assert.fail("Intentionally failed to check working");
	}
	
	@Test(dependsOnMethods = {"getAdmin"})
	public void accessJob() {
		WebElement job = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Job ']")));
		job.click();
		
		WebElement jobCategories = driver.findElement(By.xpath("//a[text()='Job Categories']"));
		jobCategories.click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}
	
}
