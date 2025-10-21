package miniproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM {
	
	public WebDriver createDriver(String urlString) {
//		Getting the ChromeDriver
		WebDriver driver = new ChromeDriver();
		driver.get(urlString);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void login(WebDriver driver, String usernameString, String passwordString, WebDriverWait wait) throws InterruptedException {
//		Enter username
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		username.sendKeys(usernameString);
		sleepOneSecond();

//		Enter password
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));;
		password.sendKeys(passwordString);
		sleepOneSecond();
		
//		Click on login
		WebElement loginButton =wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
		loginButton.click();
		sleepOneSecond();
	}
	
	public void clickOnAdmin(WebDriver driver, WebDriverWait wait) throws InterruptedException {
//		Click on Admin 
		WebElement admin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Admin']")));
		admin.click();
		sleepOneSecond();
	}
	
	public void jobCreationAndDeletion(WebDriver driver, WebDriverWait wait, String jobCategoryString, JavascriptExecutor js) throws InterruptedException {
//		Click on Job to find Job Categories
		WebElement job = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Job ']")));
		job.click();
		sleepOneSecond();
		
//		Click Job Categories
		WebElement jobCategories = driver.findElement(By.xpath("//a[text()='Job Categories']"));
		jobCategories.click();
		sleepOneSecond();
		
//		Click on add button to add job category
		WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']")));
		addButton.click();
		sleepOneSecond();
		
//		Input the category name
		WebElement categoryName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]")));
		categoryName.sendKeys(jobCategoryString);
		sleepOneSecond();
		
//		Click on save button to save the job category
		WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']")));
		saveButton.click();
		sleepOneSecond();
		
//		Getting the xpath of added job category
		String categoryXpath = "//div[text()='" + jobCategoryString + "']/parent::div/preceding-sibling::div/div/div/label/span";
//		Selecting the checkbox of added category to delete
		WebElement selectingCreatedCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(categoryXpath)));
		selectingCreatedCategory.click();
		sleepOneSecond();
		
//		Click on Delete Selected Button
		WebElement deleteSelectedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Delete Selected ']")));
		js.executeScript("arguments[0].click();", deleteSelectedButton);
		sleepOneSecond();
		
//		Click Yes, delete Button
		WebElement deleteConfirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Delete ']")));
		deleteConfirmButton.click();
		sleepOneSecond();
	}
	
	public void locationAddingAndDeleting(WebDriverWait wait, WebDriver driver, String name, String city, String state, String postalcode, String countryString, String phoneString, String addressString) throws InterruptedException {
//		Click on organization to find location
		WebElement organization = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Organization ']")));
		organization.click();
		sleepOneSecond();
		
//		Click on Locations
		WebElement locations = driver.findElement(By.xpath("//a[text()='Locations']"));
		locations.click();
		sleepOneSecond();
		
//		Click Add Button to add the location
		WebElement addLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']")));
		addLocation.click();
		sleepOneSecond();
		
//		Input Name
		WebElement locationName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]")));
		locationName.sendKeys(name);
		sleepOneSecond();
		
//		Input City
		WebElement locationCity = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[3]")));
		locationCity.sendKeys(city);
		sleepOneSecond();
		
//		Input State
		WebElement locationState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[4]")));
		locationState.sendKeys(state);
		sleepOneSecond();
		
//		Input postal Code
		WebElement locationPostalCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[5]")));
		locationPostalCode.sendKeys(postalcode);
		sleepOneSecond();
		
//		Select the country
		WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='-- Select --']")));
		country.click();
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
		List<WebElement> options = option.findElements(By.xpath(".//div[@role='option']"));
		for(WebElement element : options) {
			if(element.getText().equals(countryString)) {
				element.click();
				break;
			}
		}
		sleepOneSecond();
		
//		Input Phone
		WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[6]")));
		phone.sendKeys(phoneString);
		sleepOneSecond();
		
//		Input address
		WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Address']/parent::div/following-sibling::div/textarea")));
		address.sendKeys(addressString);
		sleepOneSecond();
		
//		Click on save button to save the location
		WebElement saveLocationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']")));
		saveLocationButton.click();
		sleepOneSecond();
		
//		Getting xpath of added location
		String locationXpath = "//div[text()='"+ name +"']/parent::div/preceding-sibling::div/div/div/label/span";
//		Selecting the checkbox of added location
		WebElement selectLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locationXpath)));
		selectLocation.click();
		sleepOneSecond();
		
//		Clicking on deleteSelectedButton
		WebElement deleteSelectedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Delete Selected ']")));
		deleteSelectedButton.click();
		sleepOneSecond();
		
//		Click on Yes, Delete button to delete
		WebElement deleteConfirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Delete ']")));
		deleteConfirmButton.click();
		sleepOneSecond();
	}
	
	public void skillAddingAndDeleting(WebDriver driver, WebDriverWait wait, String skillString, String skillDescriptionString, JavascriptExecutor js) throws InterruptedException {
//		Clicking Qualifications
		WebElement qualifications = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Qualifications ']")));
		qualifications.click();
		sleepOneSecond();
		
//		Clicking Skills in Qualification > Skills
		WebElement skills = driver.findElement(By.xpath("//a[text()='Skills']"));
		skills.click();
		sleepOneSecond();
		
//		Clicking Add Skill Button to add the Skill
		WebElement addSkillButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Add ']")));
		addSkillButton.click();
		sleepOneSecond();
		
//		Input SKill Name 
		WebElement skillName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input)[2]")));
		skillName.sendKeys(skillString);
		sleepOneSecond();
		
//		Input Skill Description
		WebElement skillDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea")));
		skillDescription.sendKeys(skillDescriptionString);
		sleepOneSecond();
		
//		Clicking on Save Button to save the skill
		WebElement saveSkillButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Save ']")));
		saveSkillButton.click();
		sleepOneSecond();
		
//		Getting Xpath of the added skill to delete
		String skillXpath = "//div[text()='" + skillString + "']/parent::div/preceding-sibling::div/div/div/label/span";
//		Clicking on the checkbox of added skill to delete
		WebElement selectSkill = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(skillXpath)));
		selectSkill.click();	
		sleepOneSecond();
		
//		Clicking Delete selected button
		WebElement deleteSelectedButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Delete Selected ']")));
		js.executeScript("arguments[0].click();", deleteSelectedButton);
		sleepOneSecond();
		
//		Clicking Yes, Delete Button
		WebElement deleteConfirmButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=' Yes, Delete ']")));
		deleteConfirmButton.click();
		sleepOneSecond();
		
//		Getting WebElements list of Skills
		List<WebElement> skillsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]/div/div/div[2]/div")));

//		Checking whether skill is deleted or not
		boolean isSkillDeleted = true;
		for(WebElement element : skillsList) {
			if(element.getText().equals("Testing Demo")) {
				isSkillDeleted = false;
				break;
			}
		}
		
		
		if(isSkillDeleted) {
			System.out.println("The Skill is deleted successfully");
		}
		else {
			System.out.println("The Skill is not deleted");
		}
		sleepOneSecond();
	}
	
	public void logoutFromPage(WebDriver driver, WebDriverWait wait) throws InterruptedException {
//		Clicking on the user profile
		WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='John Doe']")));
		user.click();
		sleepOneSecond();
		
//		Clicking on the LogOut
		WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Logout']")));
		logout.click();
		sleepOneSecond();
	}
	
	public void exitTheBrowser(WebDriver driver) {
		driver.quit();
	}
	
	public void sleepOneSecond() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String urlString = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		OrangeHRM page = new OrangeHRM();
		
//		Creating the Driver
		WebDriver driver = page.createDriver(urlString);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		
//		Properties File
		Properties props = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/miniproject/orangehrm.properties");
		props.load(fis);
		
		Thread.sleep(2000);
		
//		Login Details
		String username = props.getProperty("item.username");
		String password = props.getProperty("item.password");
		page.login(driver, username, password, wait);
		
		Thread.sleep(2000);
		
//		Go to Admin
		page.clickOnAdmin(driver, wait);
		
		Thread.sleep(2000);
		
//		Job Creation and Deletion
		String jobCategory = props.getProperty("item.jobCategory");
		page.jobCreationAndDeletion(driver, wait, jobCategory, js);
		
		Thread.sleep(2000);
		
//		Location Adding and deleting
		String name = props.getProperty("item.name");
		String city = props.getProperty("item.city");
		String state = props.getProperty("item.state");
		String postalcode = props.getProperty("item.postalcode");
		String country = props.getProperty("item.country");
		String phone = props.getProperty("item.phone");
		String address = props.getProperty("item.address");
		page.locationAddingAndDeleting(wait, driver, name, city, state, postalcode, country, phone, address);
		
		Thread.sleep(2000);
		
//		Skill Adding And Deleting
		String skillName = props.getProperty("item.skillName");
		String skillDescription = props.getProperty("item.skillDescription");
		page.skillAddingAndDeleting(driver, wait, skillName, skillDescription, js);
		
		Thread.sleep(2000);
		
//		Logout
		page.logoutFromPage(driver, wait);
		
		Thread.sleep(2000);
		
//		Exit the browser
		page.exitTheBrowser(driver);
	}
}
