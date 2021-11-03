package com.mindtree.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.resusablecomponent.BaseClass;
import com.mindtree.uistore.LoginPageUI;
import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;

public class TC_LoginTest_003 extends BaseClass {
	//This test will validate the login activity
	@Test
	public void loginTest() throws InterruptedException {
		driver.navigate().to(rp.getUrl());
		logger.info("Url is opened");
		
		test= extent.startTest("Login Test");
		LoginPageUI lg= new LoginPageUI(driver);
		lg.clickLoginLink();
		
//		driver.switchTo().frame("social_login_frame");
		lg.setEmail("ritikpatel586@gmail.com");
		logger.info("Username provided");
		lg.setPass("Ritik@123");
		logger.info("Password provided");
		lg.clickLoginBtn();
		logger.info("Clicked on signin");
		
		if(driver.getPageSource().contains("To continue, let us know you're not a robot."))
		{
			Assert.assertTrue(true);
			ExtentUtils.pass(driver, test, "Login successfully done.", logger);
//			test.log(LogStatus.PASS, "Login Test Pass");
//			logger.info("Login successfully");
		}else
		{
			ExtentUtils.fail(driver, test, "Login Failed.", logger);
			Assert.assertTrue(false);
		}
	}
}
