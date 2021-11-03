package com.mindtree.resusablecomponent;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public ReadProperties rp = new ReadProperties();
	public String baseUrl = rp.getUrl();
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static Logger logger;

	@BeforeSuite
	public void setup() {
		// log configurations
		logger = LogManager.getLogger("framework1_v1");
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");

		// extent report configurations
		extent = ExtentUtils.configure(extent, rp.getExtentReportPath());

		// starting the driver
		System.setProperty("webdriver.chrome.driver", rp.getChormeDriverPath());
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(rp.getImplicitWaitTime(), TimeUnit.SECONDS);
//		driver.manage().window().maximize();
	}
 
	@AfterSuite
	public void tearDown() {
		driver.quit(); // quitting all the drivers
		extent.flush();// adding all to extent report
	}

	@AfterMethod
	public void afterMethod() {
		extent.endTest(test);
	}

}
