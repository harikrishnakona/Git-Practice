package miniproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample {
	WebDriver driver;
	
	@BeforeClass
	public void beforClassMethod() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("BeforeClass method");
	}
	
	@Test
	public void test() {
//		Soft Assertions and Hard Assertions 
//		Soft Assertions does not stop the flow of execution when an assert an fails
//		To get failed cases use soft.assertAll() at end of that program
		Assert.assertEquals("hello", "hello1");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClassMethod() {
		driver.quit();
	}
}
