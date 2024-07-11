package tests;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

public class TestDOMElements {

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
	    public void testDOMElements() {
	        // Navigate to a demo website
	        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_password");

	        // Switch to iframe containing the form
	        driver.switchTo().frame("iframeResult");

	        // Locate input elements and interact with them
	        WebElement inputText = driver.findElement(By.cssSelector("input[type='text']"));
	        inputText.sendKeys("Selenium WebDriver");

	        WebElement inputPassword = driver.findElement(By.cssSelector("input[type='password']"));
	        inputPassword.sendKeys("selenium123");

	        // Locate button element and click it
	        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
	        submitButton.click();

	        // Handle checkboxes
	        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
	        for (WebElement checkbox : checkboxes) {
	            if (!checkbox.isSelected()) {
	                checkbox.click();
	            }
	        }
	        takeScreenshot("search_results.png");
	        // Handle radio buttons
	 //       List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));
	      //  radioButtons.get(1).click(); // Select the second radio button

	        // Handle dropdown/select element
	   //     WebElement dropdown = driver.findElement(By.cssSelector("select"));
	        // Using Select class for dropdown
	        // Select by visible text
	        // Example: Assuming options like "Volvo", "Saab", "Opel", "Audi"
	        // Select select = new Select(dropdown);
	        // select.selectByVisibleText("Volvo");

	        // Select by index
	        // select.selectByIndex(2); // Selecting "Opel" (index starts from 0)

	        // Select by value
	        // select.selectByValue("audi");

	        // Simulating a dropdown select for the example
	        // Commenting out due to incomplete Select class usage and replace the
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
	    
	    @AfterClass
	    public void tearDown() {
	        // Quit WebDriver instance
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
