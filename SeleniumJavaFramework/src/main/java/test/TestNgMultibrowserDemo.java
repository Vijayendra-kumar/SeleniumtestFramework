package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgMultibrowserDemo {

	WebDriver driver = null;
	//String projectPath = System.getProperty("user.dir");
	
	
	@BeforeTest
	@Parameters("browserName")
	public void setUP(@Optional String browserName) {
	System.out.println("Brower this time ="+browserName);	
	if(browserName.equalsIgnoreCase("Chrome")) {
		//System.setProperty("webdriver.chrome.driver",projectPath+" browser)
		driver = new ChromeDriver();
	}else if(browserName.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		
	}else if(browserName.equalsIgnoreCase("ie")) {
		driver = new InternetExplorerDriver();
	}else if(browserName.equalsIgnoreCase("edge")) {
		driver = new EdgeDriver();
	}
	}
	
	
	@Test
	public void test1() throws Exception {
		driver.get("https://google.com");
		Thread.sleep(4000);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("Test completed successfuly");
	}
}
