package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsMoveToElement {
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.spicejet.com/");
	//	Thread.sleep(3000);
		By parent = By.xpath("//div[text()='Add-ons']");
		By subMenu = By.xpath("//div[text()='Visa Services']");
		handleMenuSubMenuLevel2(parent, subMenu);
	}
	
	public static WebElement getElement(By locator) {
		WebDriverWait wait =   new WebDriverWait(driver, Duration.ofSeconds(40));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		//return driver.findElement(locator);
	}
	
	public static void handleMenuSubMenuLevel2(By parentMenuLocator, By SubMenuLocator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenuLocator)).perform();
	//	Thread.sleep(1500);
		getElement(SubMenuLocator).click();
		
	}
}
