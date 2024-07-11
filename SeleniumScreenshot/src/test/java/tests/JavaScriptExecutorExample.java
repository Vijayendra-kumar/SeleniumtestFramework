package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample {
	public static void main(String[] args) {
        
        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Navigate to a web page
        driver.get("https://www.wikipedia.org");

        // Find the search input element
        WebElement searchInput = driver.findElement(By.id("searchInput"));

        // Enter a search query using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = 'Java programming language'", searchInput);

        // Find the search button and click using JavaScript
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        js.executeScript("arguments[0].click()", searchButton);

        // Wait for search results (you might need to implement a proper wait strategy here)

        // Print the page title using JavaScript
        String pageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Page title: " + pageTitle);

        // Close the browser
        driver.quit();
    }
}
