package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FreeHRMTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/30-day-free-trial");	
      //  driver.manage().timeouts().d
        driver.findElement(By.xpath("//input[@name='subdomain' and @type='text']")).sendKeys("Vijayendra Kumar");
        driver.findElement(By.xpath("//input[@name='Name' and @type='text']")).sendKeys("Vijayendra Kumar");
        driver.findElement(By.xpath("//input[@class='email text' and @name='Email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@class='text' and @name='Contact']")).sendKeys("121212");
        
        // for selecting country i.e india in my case..
        WebElement countrylist = driver.findElement(By.xpath("//select[@name='Country' and @class='dropdown']"));
        Select select = new Select(countrylist);
        select.selectByVisibleText("India");
        
        // for taking all options (countries)
        List<WebElement> selectlist =  driver.findElements(By.xpath("//select[@name='Country' and @class='dropdown']//option"));
        
		
		  for(WebElement contry : selectlist) { 
			  System.out.println("counties are.."+contry.getText()); 
			  } 
		 
        
	}

}
