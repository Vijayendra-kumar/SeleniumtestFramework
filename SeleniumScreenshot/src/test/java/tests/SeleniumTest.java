package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setting up Chrome driver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Optional: run headless
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        // Open Google
        driver.get("https://www.google.com");

        // Find the search input element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Type "Selenium WebDriver" into the search box
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the form
        searchBox.submit();

        // Wait for search results page to load
        driver.findElement(By.id("search"));

        // Capture screenshot after search results
        takeScreenshot("google_search_results.png");
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }

    private void takeScreenshot(String filename) {
        try {
            // Capture screenshot as file
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Create directory for screenshots if it doesn't exist
            Path screenshotsDir = Paths.get("target/screenshots");
            Files.createDirectories(screenshotsDir);

            // Save screenshot to target/screenshots directory
            Files.move(screenshotFile.toPath(), screenshotsDir.resolve(filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
