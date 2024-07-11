package com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("http://www.facebook.com");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.quit();

	}

}
