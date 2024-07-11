package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample2 {
	  public static void main(String[] args) {
		     
	        // Initialize ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the web page with the table
	        driver.get("https://www.w3schools.com/html/html_tables.asp");

	        // Locate the table element
	        WebElement table = driver.findElement(By.xpath("//table[contains(@id,'cust') and contains (@class, 'ws-table-all')]")); // Replace with your table ID or other locating strategy

	        // Get all rows from the table
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	        int rowid=0;
	        // Iterate over all rows
	        for (WebElement row : rows) {
	            // Get the columns in each row
	            List<WebElement> cols = row.findElements(By.tagName("td"));

	            // Iterate over all columns in the current row and print contents
	            int colid = 1;
	            for (WebElement col : cols) {
	                System.out.print(col.getText() + "\t");
	                if(col.getText().equals("Magazzini Alimentari Riuniti")) {
	                	System.out.println("Magazzini Alimentari Riuniti is persent at row "+rowid+" and col "+colid);
	                }
	                colid++;   
	            }
	            System.out.println(); // Move to the next line after printing each row
	            rowid++;
	        }

	        // Close the browser
	        driver.quit();
	    }
}
