import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLerning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement inputtext = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
		inputtext.sendKeys("Selenium");

		WebElement submitButton = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
		submitButton.click();

		//driver.close();

		// driver.quit();
	}

}
