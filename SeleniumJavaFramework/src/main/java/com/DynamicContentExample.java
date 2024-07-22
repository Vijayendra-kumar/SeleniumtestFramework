package com;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicContentExample {

    public static void main(String[] args) {
  
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page with the dynamic content
        driver.get("https://demo.automationtesting.in/DynamicData.html");
        driver.manage().window().maximize();
        
        // Click the button to change the content
        WebElement button = driver.findElement(By.id("save")); // Replace with your button ID or other locating strategy
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        
        // Wait for the content to load and become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Adjust the timeout as needed
       wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("loading"),"First Name :"));
       WebElement loadingDiv = driver.findElement(By.id("loading"));
        // Use JavaScript executor to retrieve innerHTML
        String divContent = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;", loadingDiv);
        System.out.println("Inner HTML of loadingDiv:");
        System.out.println(divContent);
        
        // Extract information from the loading div
     //   String divContent = loadingDiv.getText().trim();
     //   System.out.println("divContent = "+divContent);
        // Parse and print First Name and Last Name
        String firstName = extractValue(divContent, "First Name : ");
        String lastName = extractValue(divContent, "Last Name : ");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

        // Close the browser
        driver.quit();
    }
    
 // Helper method to extract value using regex
    private static String extractValue(String divContent, String label) {
        String value = "";
        int startIndex = divContent.indexOf(label);
        if (startIndex != -1) {
            startIndex += label.length();
            int endIndex = divContent.indexOf("<br>", startIndex);
            if (endIndex == -1) {
                endIndex = divContent.length(); // If <br> not found, take the entire remaining string
            }
            value = divContent.substring(startIndex, endIndex).trim();
        } else {
            // Handle case where label is not found
            System.out.println("Label not found: " + label);
        }
        return value;
    }

	/*
	 * // Helper method to extract value from div content based on label private
	 * static String getValueFromDiv(String divContent, String label) { String value
	 * = ""; int startIndex = divContent.indexOf(label); if (startIndex != -1) {
	 * startIndex += label.length(); int endIndex = divContent.indexOf("<br>",
	 * startIndex); if (endIndex != -1 && endIndex > startIndex) { value =
	 * divContent.substring(startIndex, endIndex).trim(); } else { // Handle case
	 * where end index is not found or is invalid
	 * System.out.println("End index not found for label: " + label); } } else { //
	 * Handle case where label is not found System.out.println("Label not found: " +
	 * label); } return value; }
	 */
}

