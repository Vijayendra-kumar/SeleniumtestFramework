package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTableExample {

    public static void main(String[] args) {
     
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page with the table
        driver.get("file:///D:/OneDrive/OneDrive%20-%20Espire%20Infolabs%20Pvt.%20Ltd/Desktop/tabulardata.html");

        // Locate the table element
        WebElement table = driver.findElement(By.id("dynamicTable")); // Replace with your table ID or other locating strategy

        // Get all rows from the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Iterate over all rows
        for (WebElement row : rows) {
            // Get the columns in each row
            List<WebElement> cols = row.findElements(By.tagName("td"));

            // Iterate over all columns in the current row and print contents
            for (WebElement col : cols) {
                System.out.print(col.getText() + "\t");
            }
            System.out.println(); // Move to the next line after printing each row
        }

        // Close the browser
        driver.quit();
    }
}
