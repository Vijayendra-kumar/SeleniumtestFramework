package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadProgressExample {

    public static void main(String[] args) {
     
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to your web page with the download button
        driver.get("https://demo.automationtesting.in/JqueryProgressBar.html");
        driver.manage().window().maximize();
        // Click the download button
        WebElement downloadButton = driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        // Wait for the progress dialog to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-dialog-content")));

       

        // Continuously monitor progress label and progress bar
        boolean downloadCompleted = false;
        while (!downloadCompleted) {
            // Read progress label
            WebElement progressLabel = dialog.findElement(By.className("progress-label"));
            String progressLabelText = progressLabel.getText();
            System.out.println("Progress Label: " + progressLabelText);

            // Read progress bar value
            WebElement progressBar = dialog.findElement(By.id("progressbar"));
            String progressBarValue = progressBar.getAttribute("aria-valuenow");
            System.out.println("Progress Bar Value: " + progressBarValue);

            // Check if download is completed
            if (progressLabelText.equalsIgnoreCase("Complete!") && progressBarValue.equals("100")) {
                downloadCompleted = true;
            }

            // Optionally add a delay to control the frequency of checks
            try {
                Thread.sleep(1000); // Wait for 1 second before checking again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Refresh the dialog element to avoid StaleElementReferenceException
            dialog = driver.findElement(By.cssSelector(".ui-dialog-content"));
        }

        //  
        // Click the Close button
        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        closeButton.click();
        
        // Close the browser
        driver.quit();
    }
}