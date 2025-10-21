 
package miniproject;
 
import java.time.Duration;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class MiniProject {
 
    @Test
    public void deleting() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        Thread.sleep(1000);
        actions.moveToElement(loginButton).click().perform();
 
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='oxd-main-menu-item']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/span/i"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Job Categories']"))).click();
        Thread.sleep(1000);
 
        WebElement addJobCategory = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        addJobCategory.click();
 
        WebElement jobCategoryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//input[contains(@class, 'oxd-input')])[2]")));
        jobCategoryInput.sendKeys("Test Engineer");
 
        Thread.sleep(1000);
 
        List<WebElement> jobCategoryErrors = driver.findElements(
            By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
 
        if (!jobCategoryErrors.isEmpty()) {
            System.out.println("Test Engineer already exists. Cancelling addition.");
            WebElement cancelJobCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")));
            cancelJobCategory.click();
        } else {
            WebElement saveJobCategory = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
            saveJobCategory.click();
            Thread.sleep(2000);
        }
 
        WebElement jobCategoryCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[@class='oxd-checkbox-wrapper']/child::label")));
        jobCategoryCheckbox.click();
 
        WebElement deleteJobCategory = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[contains(@class,'oxd-button--label-danger')]")));
        deleteJobCategory.click();
 
        WebElement confirmDeleteJobCategory = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")));
        confirmDeleteJobCategory.click();
 
        Thread.sleep(2000);
 
        WebElement organization = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[@class='oxd-topbar-body-nav-tab-item' and contains(text(),'Organization')]")));
        organization.click();
 
        WebElement locations = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@class='oxd-topbar-body-nav-tab-link' and contains(text(),'Locations')]")));
        locations.click();
 
        Thread.sleep(2000);
 
        WebElement addLocation = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")));
        addLocation.click();
 
        WebElement locationName = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
        locationName.sendKeys("Hyderabad");
 
        Thread.sleep(1000);
 
        List<WebElement> locationErrors = driver.findElements(
            By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
 
        if (!locationErrors.isEmpty()) {
            System.out.println("Hyderabad already exists. Cancelling addition.");
            WebElement cancelLocation = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']")));
            cancelLocation.click();
        } else {
            WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='oxd-select-text-input']")));
            countryDropdown.click();
 
            List<WebElement> countryOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@role='listbox']//div[@class='oxd-select-option']")));
 
            for (WebElement option : countryOptions) {
                if (option.getText().trim().equalsIgnoreCase("India")) {
                    option.click();
                    break;
                }
            }
 
            WebElement saveLocation = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")));
            saveLocation.click();
            Thread.sleep(2000);
        }
 
        WebElement locationCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//div[@class='oxd-checkbox-wrapper']/label)[1]")));
        locationCheckbox.click();
 
        WebElement deleteLocation = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-horizontal-margin']")));
        deleteLocation.click();
 
        WebElement confirmDeleteLocation = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")));
        confirmDeleteLocation.click();
 
        Thread.sleep(2000);
        driver.quit();
    }
}
 
 