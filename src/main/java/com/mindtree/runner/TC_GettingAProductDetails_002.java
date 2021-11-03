package com.mindtree.runner;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.resusablecomponent.BaseClass;
import com.mindtree.uistore.HomePageUI;
import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;

public class TC_GettingAProductDetails_002 extends BaseClass {
	// This Test will fetch the Product details
	@Test
	public void getProductDetails() throws InterruptedException {
	driver.navigate().to(rp.getUrl());
	logger.info("Url is opened");
	Thread.sleep(2000);
	
	test= extent.startTest("Get Product Details");
	
	HomePageUI hm= new HomePageUI(driver);
	//clicking on a product
	hm.clickOnProductBookSet();
	logger.info("Clicked on a product ELOCALSHOP BOX - 10 books");
	
	String productPrice= hm.getBookSetPrice();
	System.out.println("Product Price is: "+ productPrice);
	logger.info("Got the price of product");
	
	String discount= hm.getBookSetDiscount();
	System.out.println("Discount is: "+ discount.substring(5));
	logger.info("Got the discount on product");
	
	if(!discount.equals("")){
		ExtentUtils.pass(driver, test, "Able to fetch the Product details.", logger);
		Assert.assertTrue(true);
//		logger.info("getProductDetails Test passed.");
//		test.log(LogStatus.PASS, "Able to fetch the Product details.");
	}
	else
	{
		ExtentUtils.fail(driver, test, "Couldn't fetch The details"+test.getTest().getName()+" Failed", logger);
		Assert.assertTrue(false);
	}
	}
}
