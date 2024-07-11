package com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown {

	public static void main(String[] args) {
		// //div[@class='_6ltg']//a[@role='button' and text()='Create new account' and @data-testid='open-registration-form-button']
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//div[@class='_6ltg']//a[@role='button' and text()='Create new account' and @data-testid='open-registration-form-button']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement month =	driver.findElement(By.xpath("//select[@aria-label='Month' and @name='birthday_month']"));
	Select select = new Select(month);
	
	select.selectByIndex(4);
	select.selectByVisibleText("Jul");
	
	List<WebElement> optionlist = driver.findElements(By.xpath("//select[@aria-label='Month' and @name='birthday_month']//option"));
	
	for (WebElement option : optionlist) {
		System.out.println("Month lists are : "+option.getText());
	}
	
	
	
	}

}
