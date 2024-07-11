package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsExample {
private WebDriver driver;

private ExtentTest test;
private ExtentReports extent;

@BeforeClass
public void setUp() {
	
	driver = new ChromeDriver();
	  // Initialize ExtentReports and attach the HtmlReporter
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/extent_example.html");
	 extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
}
@Test
public void extentReportTest() {
	test = extent.createTest("extentReportTest","This is Demo test for Extent Reports");
	
	driver.get("https://www.wikipedia.org");
	
	 // Perform some actions and capture results
    WebElement searchInput = driver.findElement(By.id("searchInput"));
    searchInput.sendKeys("Selenium (software)");

    WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
    searchButton.click();
    // Assertion (dummy assertion for demonstration)
    String pageTitle = driver.getTitle();
    if (pageTitle.contains("Selenium (software)")) {
        test.log(Status.PASS, "Search page title verified");
    } else {
        test.log(Status.FAIL, "Search page title verification failed");
    }
  }
@AfterClass
public void tearDown() {
    // Close the browser
    driver.quit();

    // Flush the ExtentReports instance
    extent.flush();
}
}
