package miniproject;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EnquiryOfBuildingProject {
	
	
	WebDriver driver;
	String urlString = "https://ishahomes.com/";
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public void createDriver() {
//		Getting the ChromeDriver
		driver = new ChromeDriver();
		driver.get(urlString);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
	}
	
//	Function to close the pop ups
	public void closePopUp() throws InterruptedException {
		WebElement popupElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("livchat_close")));
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", popupElement);
		
		WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close-indicator']")));
		js.executeScript("arguments[0].click()", close);
		
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].click();", popupElement);
		
		Thread.sleep(2000);
	}
	
//	Open completed projects and printing first 5 completed projects
	public void openCompletedProjects() throws InterruptedException {
		WebElement completedProjects = driver.findElement(By.xpath("//li[@id='menu-item-25810']/a"));
		completedProjects.click();
		
		Thread.sleep(2000);
		
		WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close-indicator']")));
		js.executeScript("arguments[0].click()", close);
		
		Thread.sleep(2000);
		
		List<WebElement> totalProjects = driver.findElements(By.xpath("//div[@id='module_properties']/*"));
		System.out.println("No. of projects completed are: " + totalProjects.size());
		
		System.out.println();
		
		System.out.println("The first five completed projects are");
		
		for(int i=0 ; i<5 ; i++) {
			WebElement project = totalProjects.get(i);
			WebElement title = project.findElement(By.xpath("div/div/div[2]/h2"));
			System.out.println(title.getText());
		}
		
		Thread.sleep(2000);
	}
	
//	Getting the contact email
	public String getContactEmail() throws InterruptedException {
		WebElement more = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='More'])[1]")));
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		actions.moveToElement(more).perform();
		
		Thread.sleep(2000);
		
		more.click();
	
		WebElement contactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-24517']//a")));
		contactInfo.click();
		
		Thread.sleep(2000);
		
		WebElement close3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='close-indicator']")));
		js.executeScript("arguments[0].click()", close3);
		
		
		WebElement mailId = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main-wrap\"]/div/section[3]/div/div[1]/div/div[1]/div/div/div/div/p[5]/a")));
		actions.moveToElement(mailId).perform();
		System.out.println();
//		System.out.println("The Email Address for contact is " + mailId.getText());
		
		Thread.sleep(2000);
		
		return mailId.getText();
	}
	
//	Taking the screenshot of contact page
	public void takeScreenshot() throws IOException, InterruptedException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		Path destFile = Paths.get("src/test/java/miniproject/screenshot.png");
		
		Files.move(screenshotFile.toPath(), destFile, REPLACE_EXISTING);
		
		Thread.sleep(5000);
	}
	
//	Closing the browser
	public void closeBrowser() {
		driver.quit();
	}
	
	
	public static void main(String[] args) throws InterruptedException, IOException {
		EnquiryOfBuildingProject project = new EnquiryOfBuildingProject();
		
		project.createDriver();
		project.closePopUp();
		project.openCompletedProjects();
		String emailString = project.getContactEmail();
		System.out.println("The Email Address for contact is " + emailString);
		project.takeScreenshot();
		project.closeBrowser();
	}
}
