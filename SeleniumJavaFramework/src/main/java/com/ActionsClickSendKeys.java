package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {
	static WebDriver driver;
	
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email = By.id("input-email");
		By password = By.id("input-password");
		By login = By.xpath("//input[@value='Login']");
		
		//Actions act = new Actions(driver);
		//act.sendKeys(driver.findElement(email),"test@gmail.com").perform();
		doActionsSendKeys(email,"test@gmail.com");
		//act.sendKeys(driver.findElement(password),"test@123").perform();
		doActionsSendKeys(password,"test@123");
	//	act.click(driver.findElement(login)).perform();
		doActionsClick(login);
		
		
		String alertmsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println("alertmsg = "+alertmsg);
		assert alertmsg.equals(alertmsg) : "Title mismatch";
		
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();

		
	}
}
