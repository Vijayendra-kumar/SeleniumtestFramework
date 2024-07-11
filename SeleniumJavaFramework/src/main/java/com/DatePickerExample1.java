package com;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerExample1 {
static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	//	driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://demo.automationtesting.in/Datepicker.html");
	//	Thread.sleep(3000);
		
	// Locate the date input field and click on it to open the datepicker
		By datepicker1 =	By.id("datepicker1");
		getElement(datepicker1).click();
		
		
		 // Select date using datepicker
        LocalDate desiredDate = LocalDate.of(2025, 9, 13); // Example date to select
        selectDate(driver, desiredDate);

        // Close the browser
      //  driver.quit();
	}
	
	public static WebElement getElement(By locator) {
		WebDriverWait wait =   new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		//return driver.findElement(locator);
	}
	
	public static void selectDate(WebDriver driver, LocalDate date) {
        // Format the desired date into a string that matches the datepicker format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMMM/yyyy");
        String desiredDateString = date.format(formatter);

        // Split the date into day, month, and year
        String[] dateParts = desiredDateString.split("/");
        String day = dateParts[0];
        String desiremonth = dateParts[1];
        System.out.println("desiremonth = "+desiremonth);
        String desireyear = dateParts[2];
        System.out.println("desireyear = "+desireyear);
        
        // Find and click the year & Month selector
        By yearMonthSelector = By.xpath("//img[@class='imgdp']");
        getElement(yearMonthSelector).click();

        //Reading current Year from picker.
        By currentY = By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-year']");
        String currentYear =  getElement(currentY).getText();
        System.out.println("currentYear = "+currentYear);
        
       
        
        By prv = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");
        By next = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
        // Click next or previous button until desired month and year is reached
        
        //Year comparison
        while (!currentYear.equals(desireyear) ) {
            // Determine whether to click next or previous based on desired vs current month and year
            if (desireyear.compareTo(currentYear) < 0) {
            //	System.out.println("desireyear.compareTo(currentYear) < 0 ="+desireyear+" and "+currentYear);
                // Click previous button
            	getElement(prv).click();
               // driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            } else {
            	//System.out.println("else of year while "+desireyear+" and "+currentYear);
                // Click next button
            	getElement(next).click();
               // driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }

            
            // Update current  year text
              currentYear = getElement(currentY).getText();
              System.out.println("after update by year while currentYear ="+currentYear);
              
        }
        
        //Reading current Month from picker.
        By currentM = By.xpath("//div[@class='ui-datepicker-title']//span[@class='ui-datepicker-month']");
        String currentMonth =  getElement(currentM).getText();
        System.out.println("currentMonth = "+currentMonth);
        
        //month comparison 
        while (!currentMonth.equals(desiremonth) ) {
            // Convert month names to Month enum values
            Month desire = Month.valueOf(desiremonth.toUpperCase());
            Month current = Month.valueOf(currentMonth.toUpperCase());
        
            // Determine whether to click next or previous based on desired vs current month and year
            if (desire.compareTo(current) < 0) {
            
            	 System.out.println(desiremonth + " comes before " + currentMonth);
                // Click previous button
            	getElement(prv).click();
               // driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
            } else if (desire.compareTo(current) > 0){
           
            	System.out.println(desiremonth + " comes after " + currentMonth);
                // Click next button
            	getElement(next).click();
               // driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
            }else {
            	 System.out.println(desiremonth + " and " + currentMonth + " are the same month");
            }
            // Update current month  text
            currentMonth = getElement(currentM).getText();
            System.out.println("after update by month while currentMonth ="+currentMonth);
        }
        
        System.out.println("After loop : currentYear = "+currentYear);
        System.out.println("After loop : currentMonth = "+currentMonth);
        
        
     
        // Find and click the day of the month //table[@class='ui-datepicker-calendar']//a[text()='30']
        By  desiredDay = By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + day + "']");
        getElement(desiredDay).click();
    }

}

