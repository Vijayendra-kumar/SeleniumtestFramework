

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GSearchTestNG {
	WebDriver driver = null;

	@BeforeTest
	public void setPath() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}

	@Test
	public void googleSearch() {
		WebElement inputtext = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		inputtext.sendKeys("Selenium");

		WebElement submitButton = driver.findElement(By.cssSelector(
				"body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
		submitButton.click();
	}

	@AfterTest
	public void tearDownDriver() {
		driver.close();

		// driver.quit();

	}

}
