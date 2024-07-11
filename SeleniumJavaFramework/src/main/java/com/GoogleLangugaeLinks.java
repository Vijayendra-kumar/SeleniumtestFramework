package com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLangugaeLinks {

	public static void main(String[] args) {
		// GoogleLangugaeLinks
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("http://www.google.co.in");
		
		/*
		 * List<WebElement> linkLists =
		 * driver.findElements(By.xpath("//div[@id='SIvCob']//a"));
		 * System.out.println("total number of language links: "+ linkLists.size());
		 * 
		 * for(int i=0; i<linkLists.size(); i++){
		 * System.out.println(linkLists.get(i).getText());
		 * 
		 * if(linkLists.get(i).getText().equals("मराठी")){ linkLists.get(i).click();
		 * break; } }
		 */
		WebElement divElement = driver.findElement(By.xpath("//div[@id='SIvCob']"));
		
		List<WebElement> anchorElements = divElement.findElements(By.tagName("a"));
		
		for(WebElement anchor : anchorElements) {
			System.out.println(anchor.getText());
		}
		
		driver.quit();
	}

}
