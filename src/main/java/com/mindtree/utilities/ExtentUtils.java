package com.mindtree.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentUtils {
	public static ExtentReports configure(ExtentReports extent,String extentReportPath) {
		String extentPath = extentReportPath + "extentReport_"
				+ System.currentTimeMillis() + ".html";
		extent = new ExtentReports(extentPath);
		return extent;
	}
	
	public static void pass(WebDriver driver, ExtentTest test, String msg, Logger log) {
		test.log(LogStatus.PASS, "Passed: "+msg);
		log.debug(msg);
		ScreenshotUtils.capture(driver, System.getProperty("user.dir")+"/screenshots/pass/"+System.currentTimeMillis()+".png");
	}
	
	public static void fail(WebDriver driver, ExtentTest test, String msg, Logger log){
		String screenPath= ScreenshotUtils.capture(driver, System.getProperty("user.dir")+"/screenshots/fail/"+System.currentTimeMillis()+".png");
		test.log(LogStatus.FAIL, "Failed: "+msg);
		test.log(LogStatus.FAIL, test.addScreenCapture(screenPath));
		log.debug(msg);
	}
	public static void skip(WebDriver driver, ExtentTest test, String msg, Logger log) {
		test.log(LogStatus.SKIP, "Skipped: "+msg);
	}
//	public static void updateExtentLogs(ExtentTest test, ITestResult result, WebDriver driver, String msg) {
//	if (result.getStatus() == ITestResult.FAILURE) {
//		// to extent report
//		test.log(LogStatus.FAIL, result.getName() + ": Test Failed!");
////		test.log(LogStatus.FAIL, result.getThrowable());
//		test.log(LogStatus.FAIL, test.addScreenCapture(ScreenshotUtils.capture(driver)));
//	}
//	else if(result.getStatus() == ITestResult.SUCCESS)
//	{
//		test.log(LogStatus.PASS, result.getName()+" Test Passed: "+msg);
//	}
//}
}

