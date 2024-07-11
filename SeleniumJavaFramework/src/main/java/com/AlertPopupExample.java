package com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupExample {
	static WebDriver driver;
	public static void main(String[] args)  {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 // Open the URL
        driver.get("https://demo.automationtesting.in/Alerts.html");
        try {
        alterWithOk();
        alterWithOkCancel();
        alterWithTextBox();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}
	private static void alterWithOk() throws InterruptedException {
		
            // Click on the Alert with OK button
            WebElement alertButton = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK ')]"));
            alertButton.click();
            
            // Click on the Alert with OK button
            WebElement alertcallbutton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
            alertcallbutton.click();   

            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the text from the alert
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);

            // Accept the alert (click OK)
            alert.accept();

            // Wait for a while to see the alert being handled
            Thread.sleep(3000);

       
	}
	
	private static void alterWithOkCancel() throws InterruptedException {
		
            // Click on the Alert with OK button
            WebElement alertButton = driver.findElement(By.xpath("//a[contains(text(),'Alert with OK & Cancel ')]"));
            alertButton.click();
            
            // Click on the Alert with OK button
            WebElement alertcallbutton = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
            alertcallbutton.click();   

            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the text from the alert
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);

            // Accept the alert (click OK)
         //   alert.accept();

            // Dismiss the alert (click Cancel)
            alert.dismiss();
            
            // Wait for a while to see the alert being handled
            Thread.sleep(3000);

      
	}
	
	private static void alterWithTextBox() throws InterruptedException {
		//Click on the Alert with OK button
            WebElement alertButton = driver.findElement(By.xpath("//a[contains(text(),'Alert with Textbox ')]"));
            alertButton.click();
            
            // Click on the Alert with OK button
            WebElement alertcallbutton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
            alertcallbutton.click();   

            // Switch to the alert
            Alert alert = driver.switchTo().alert();
            
         // Enter text into the alert textbox
            String inputText = "Hello, this is a test message";
            alert.sendKeys(inputText);

            // Get the text from the alert
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);

            // Accept the alert (click OK)
            alert.accept();

            // Wait for a while to see the alert being handled
            Thread.sleep(3000);

      
	}
}
