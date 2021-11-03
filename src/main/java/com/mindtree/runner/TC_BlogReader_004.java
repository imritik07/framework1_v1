package com.mindtree.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.resusablecomponent.BaseClass;
import com.mindtree.uistore.BlogReaderUI;
import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;

public class TC_BlogReader_004 extends BaseClass {
	// This test will read the blog
	@Test(priority=0)
	public void readBlog() {
		driver.navigate().to(rp.getUrl());
		logger.info("Url is opened");
		
		test= extent.startTest("Read A Blog");
		
		BlogReaderUI blog= new BlogReaderUI(driver);
		blog.clickLinkBlog();
		blog.clickLinkToHoliBlog();
		
		String content= blog.getParaContent();
		System.out.println(content);

		if(!content.equals(null)) {
			Assert.assertTrue(true);
			ExtentUtils.pass(driver, test, "Blog read Successfully", logger);
//			test.log(LogStatus.PASS, "Blog read Successfully");
//			logger.info("Read Blog Test done");
		}
		else {
			ExtentUtils.fail(driver, test, "Couldn't read the Blog", logger);
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority= 1)
	public void leaveAComment() {
		test= extent.startTest("LeaveAComment");
		BlogReaderUI blog= new BlogReaderUI(driver);
		blog.setEmail("john@gmail.com");
		blog.setName("John");
		blog.setMessage("Content is Nice!");
		
		blog.clickSubmitComment();
		
		if(driver.getPageSource().contains("To continue, let us know you're not a robot."))
		{
			ExtentUtils.pass(driver, test, "Comment has been posted", logger);
			Assert.assertTrue(true);
		}
		else {
			ExtentUtils.pass(driver, test, "Comment couldn't be posted", logger);
			Assert.assertTrue(false);
		}
	}
}
