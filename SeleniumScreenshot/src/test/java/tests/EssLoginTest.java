package tests;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class EssLoginTest {
	private WebDriver driver;
	private ExtentTest test;
	private ExtentReports extent;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		// Initialize ExtentReports and attach the HtmlReporter
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ess_test_report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test(priority = 1)
	public void getLoginPage() {
		test = extent.createTest("getLoginPage", "This is Ess loging Page test.");
		driver.get("https://ess.espire.com/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Define the expected condition

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				String currentUrl = driver.getCurrentUrl();
				// System.out.println("currentUrl = "+currentUrl);
				if (currentUrl.contains("/login")) {
					// System.out.println("/login = true");
					return true;
				}

				return false;
			}
		};

		// Wait until the condition is met
		wait.until(condition);
		try {

			Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label='LOGIN WITH SSO']")).isDisplayed(),
					"Loging page apear sucucessfully.");

			test.log(Status.PASS, "Ess Login page loaded succesfully!!");
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Loging page load failed " + e.getMessage());

		}

	}

	@Test(dependsOnMethods = "getLoginPage")
	public void clickLoginButton() {
		test = extent.createTest("clickLoginButton", "Click on Loging button.");
		driver.findElement(By.xpath("//button[@aria-label='LOGIN WITH SSO']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Define the expected condition

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				WebElement inputtextfield = driver.findElement(By.xpath("//input[@type='email' and @name='loginfmt']"));
				if (inputtextfield.isDisplayed()) {
					// System.out.println("inputtextfield Displayed");
					return true;
				}
				// System.out.println("inputtextfield does not Displayed");
				return false;
			}
		};

		// Wait until the condition is met
		wait.until(condition);

		try {
			WebElement inputusername = driver.findElement(By.xpath("//input[@type='email' and @name='loginfmt']"));
			System.out.println("inputusername place value ="+inputusername.getAttribute("placeholder"));
			Assert.assertTrue(inputusername.isDisplayed());
			test.log(Status.PASS, "Ess Login page loaded succesfully!!");
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Loging page load failed " + e.getMessage());
		}
	}
	
	 @Test(dependsOnMethods = "clickLoginButton")
	    public void verifyWrongUsernameErrorMessage() {
	        // Enter an incorrect username
		 test = extent.createTest("verifyWrongUsernameErrorMessage", "Verify alert msg if wrong username provided.");
	        String incorrectUsername = "invalid.username@espire.com";
	        WebElement usernameInput = driver.findElement(By.xpath("//input[@type='email' and @name='loginfmt']"));
	        usernameInput.sendKeys(incorrectUsername);
	        
	        driver.findElement(By.xpath("//input[@type='submit' and @value='Next']")).click();
	     // Define the expected condition
	        
	         
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					//WebElement inputtextfield = driver.findElement(By.xpath("//input[@type='email' and @name='loginfmt']"));
					WebElement  errorMessageDiv = driver.findElement(By.id("usernameError"));
					if (errorMessageDiv.isDisplayed()) {
						 System.out.println("errorMessageDiv Displayed");
						return true;
					}
					 System.out.println("errorMessageDiv does not Displayed");
					return false;
				}
			};

			// Wait until the condition is met
			wait.until(condition);
	        // Find the div element with error message near the username input //input[@type='submit' and @value='Next']
	       
			try {
	        // Verify if the error message is displayed passwordError //input[@type='password' and @name='passwd']
	        Assert.assertTrue(driver.findElement(By.id("usernameError")).isDisplayed(), "Error message div is not displayed");

	        // Verify the error message text
	        String actualErrorMessage = driver.findElement(By.id("usernameError")).getText();
	        String expectedErrorMessage = "This username may be incorrect. Make sure you typed it correctly. Otherwise, contact your admin.";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text does not match");
	        test.log(Status.PASS, "Error message div is displayed and Error message text match!!");
			} catch(AssertionError e) {
				test.log(Status.FAIL, "Error message text does not match: " + e.getMessage());
	        }
	    }
	 
	 @Test(dependsOnMethods = "verifyWrongUsernameErrorMessage")
	    public void verifyWrongPasswordErrorMessage() {
	        // Enter an incorrect username
		 test = extent.createTest("verifyWrongPasswordErrorMessage", "Verify alert msg if wrong password provided.");
	        String correctUsername = "vijayendra.kumar@espire.com";
	        WebElement usernameInput = driver.findElement(By.xpath("//input[@type='email' and @name='loginfmt']"));
	        usernameInput.clear();
	        usernameInput.sendKeys(correctUsername);
	        
	        driver.findElement(By.xpath("//input[@type='submit' and @value='Next']")).click();
	     // Define the expected condition
	        
	         
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					WebElement inputtextfield = driver.findElement(By.xpath("//input[@type='password' and @name='passwd']"));
					//WebElement  errorMessageDiv = driver.findElement(By.id("usernameError"));
					if (inputtextfield.isDisplayed()) {
						 System.out.println("inputtextfield Displayed");
						return true;
					}
					 System.out.println("inputtextfield does not Displayed");
					return false;
				}
			};

			// Wait until the condition is met
			wait.until(condition);
	        // enter password input //input[@type='submit' and @value='Next']
			 String incorrectPassword = "q123";
		        WebElement usernameInputpass = driver.findElement(By.xpath("//input[@type='password' and @name='passwd']"));
		        usernameInputpass.sendKeys(incorrectPassword);
		        
		        driver.findElement(By.xpath("//input[@type='submit' and @data-report-event='Signin_Submit']")).click();
			try {
				
				 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					ExpectedCondition<Boolean> condition1 = new ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(WebDriver driver) {
							//WebElement inputtextfield = driver.findElement(By.xpath("//input[@type='password' and @name='passwd']"));
							WebElement  errorMessageDiv = driver.findElement(By.id("passwordError"));
							if (errorMessageDiv.isDisplayed()) {
								 System.out.println("errorMessageDiv Displayed");
								return true;
							}
							 System.out.println("errorMessageDiv does not Displayed");
							return false;
						}
					};

					// Wait until the condition is met
					wait1.until(condition1);
	        // Verify if the error message is displayed passwordError //input[@type='password' and @name='passwd']https://ess.espire.com/dashboard
	        Assert.assertTrue(driver.findElement(By.id("passwordError")).isDisplayed(), "Error message div is not displayed");

	        // Verify the error message text
	        String actualErrorMessage = driver.findElement(By.id("passwordError")).getText();
	        String expectedErrorMessage = "Your account or password is incorrect. If you don't remember your password, reset it now.";
	        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text does not match");
	        test.log(Status.PASS, "Error message div is displayed and Error message text match!!");
			} catch(AssertionError e) {
				test.log(Status.FAIL, "Error message text does not match: " + e.getMessage());
	        }
	    }
	 @Test(dependsOnMethods = "verifyWrongPasswordErrorMessage")
	    public void verifyEssLoginSuccess() {
	        // Enter an incorrect username
		 test = extent.createTest("verifyEssLoginSuccess", "Verify whethere ess login successful.");
	      
	        // enter password input //input[@type='submit' and @value='Next']
			 String correctPassword = "Syscon@June06";
		        WebElement usernameInputpass = driver.findElement(By.xpath("//input[@type='password' and @name='passwd']"));
		        usernameInputpass.clear();
		        usernameInputpass.sendKeys(correctPassword);
		        
		        driver.findElement(By.xpath("//input[@type='submit' and @data-report-event='Signin_Submit']")).click();
			try {
				
				 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
					ExpectedCondition<Boolean> condition1 = new ExpectedCondition<Boolean>() {
						@Override
						public Boolean apply(WebDriver driver)  {
							String currentUrl = driver.getCurrentUrl();
							// System.out.println("currentUrl = "+currentUrl);
							if (currentUrl.contains("/dashboard")) {
								 System.out.println("/dashboard = true");
								return true;
							}
							System.out.println("/dashboard = false");
							return false;
						}
					};

					// Wait until the condition is met
					wait1.until(condition1);
	        // Verify if https://ess.espire.com/dashboard loaded.
	        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Error message home page does not displayed");
	        takeScreenshot("ess_home_page.png");
	         test.log(Status.PASS, "https://ess.espire.com/dashboard loaded.!!");
			} catch(AssertionError e) {
				test.log(Status.FAIL, "Error message: Home page cound not be loaded." + e.getMessage());
	        }
	    }
	// Example method for waiting until an element is visible
	 //   private static void waitForElementToBeVisible(WebDriver driver, By locator) {
	        // Implement your own wait strategy, e.g., WebDriverWait
	        // Example:
	        // WebDriverWait wait = new WebDriverWait(driver, 10);
	        // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 //   }
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
		// Close the browser
		// driver.quit();

		// Flush the ExtentReports instance
		 extent.flush();
	}
}
