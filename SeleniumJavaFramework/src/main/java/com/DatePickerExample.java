package com;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerExample {
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
		By datepicker1 =	By.id("datepicker2");
		getElement(datepicker1).click();
		
		
		 // Select date using datepicker
        LocalDate desiredDate = LocalDate.of(2024, 8, 15); // Example date to select
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
        String month = dateParts[1];
        String year = dateParts[2];

        // Find and click the year selector
        By YearSelector = By.xpath("//select[@class='datepick-month-year' and @title='Change the year']");
        getElement(YearSelector).click();

      
        // Find the desired year and click on it //select[@class='datepick-month-year' and @title='Change the year']//option[text()='2023']
        By desiredYear = By.xpath("//select[@class='datepick-month-year' and @title='Change the year']//option[text()='" + year + "']");
        getElement(desiredYear).click();
        
        // Find and click the month selector //select[@class='datepick-month-year' and @title='Change the month']//option[text()='September']
        By monthSelector = By.xpath("//select[@class='datepick-month-year' and @title='Change the month']");
        getElement(monthSelector).click();

      

        // Find the desired month and click on it
        By desiredMonth = By.xpath("//select[@class='datepick-month-year' and @title='Change the month']//option[text()='" + month + "']");
        getElement(desiredMonth).click();

        // Find and click the day of the month //table[@class='ui-datepicker-calendar']//a[text()='30']
        By  desiredDay = By.xpath("//a[text()='" + day + "']");
        getElement(desiredDay).click();
    }

}
