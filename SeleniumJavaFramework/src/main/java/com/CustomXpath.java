package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();

		driver.get("https://ui.cogmento.com/");
		
		//driver.findElement(By.xpath("//input[@name = 'email' and @type = 'text']")).sendKeys("testuser");
		//driver.findElement(By.xpath("//input[@name='password' and @type = 'password']")).sendKeys("test@123");
		
		//total text fields on the page: 
				List<WebElement> textboxList = driver.findElements(By.tagName("input"));
				System.out.println("total text boxes: "+ textboxList.size());
				
				for(int i=0; i<textboxList.size(); i++){
					textboxList.get(i).sendKeys("admin");
				}
				
		WebElement loginbtn = driver.findElement(By.xpath("//div[@class = 'ui fluid large blue submit button' and text() ='Login']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginbtn);
		
	 driver.quit();	
	}

}
