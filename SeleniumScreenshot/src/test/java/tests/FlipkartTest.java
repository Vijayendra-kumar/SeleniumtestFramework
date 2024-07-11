package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class FlipkartTest {
    private WebDriver driver;
    private String baseUrl = "https://www.flipkart.com/";

    @BeforeClass
    public void setUp() {
          
        driver = new ChromeDriver();
        driver.manage().window().maximize();
      }

    @Test
    public void testMouseOver() {
        // Open Flipkart website
        driver.get(baseUrl);
        WebDriverWait wait =   new WebDriverWait(driver, Duration.ofSeconds(40));
        // Example: Perform mouse-over action
        WebElement electronicsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Electronics']")));
       // WebElement electronicsMenu = driver.findElement(By.xpath("//div[text()='Electronics']"));
        Actions actions = new Actions(driver);//div[text()='Electronics']
        actions.moveToElement(electronicsMenu).perform();

        // Example: Click on a sub-menu item
        WebElement samsungLink = driver.findElement(By.xpath("//a[text()='Electronics GST Store']"));
        samsungLink.click();

        // Example: Assert the title after navigation
        String expectedTitle = "GST Store";
        String actualTitle = driver.findElement(By.xpath("//h1[text()='GST Store']")).getText();
        assert actualTitle.equals(expectedTitle) : "Title mismatch";
    }

    @AfterClass
    public void tearDown() {
        // Close WebDriver
        if (driver != null) {
          //  driver.quit();
        }
    }
}
