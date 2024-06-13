package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentWithTestNGDemo {

	ExtentSparkReporter htmlrept;
	ExtentReports extent;

	@BeforeTest
	public void setUp() {

		htmlrept = new ExtentSparkReporter("extentSparkRept.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlrept);
	}


	@Test
	public void test1() {

		ExtentTest test = extent.createTest("My Test1","Test1 Description");
		test.log(Status.INFO,"This step shows usage of log(status,details");
		test.info("This step will show use of INFO");

		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	}

	@Test
	public void test2() {

		ExtentTest test = extent.createTest("My Test1","Test1 Description");
		test.log(Status.INFO,"This step shows usage of log(status,details");
		test.info("This step will show use of INFO");

		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}
