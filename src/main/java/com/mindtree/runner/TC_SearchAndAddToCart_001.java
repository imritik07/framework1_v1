package com.mindtree.runner;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mindtree.resusablecomponent.BaseClass;
import com.mindtree.uistore.HomePageUI;
import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;

public class TC_SearchAndAddToCart_001 extends BaseClass {
	// This test will search a product and add it to the cart.
	@Test
	public void searchProduct() throws InterruptedException {
		test = extent.startTest("SearchAndAddToCartProduct");
		driver.navigate().to(rp.getUrl());
		logger.info("Url is opened");

		HomePageUI hm = new HomePageUI(driver);
		hm.searchAProduct("The Power of Your Subconscious Mind");
		logger.info("Product name provided");
		hm.clickSearch();
		logger.info("Clicked on search");

		Thread.sleep(2000);
		// clicking on product
		hm.clickOnProduct();

		// selecting quantity on next page
		Select s = new Select(hm.getSelector());
		hm.clickOnSelector();
		s.selectByValue("3");

		hm.clickOnAddCartBtn();
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Added to your cart:")) {
			Assert.assertTrue(true);
//			test.log(LogStatus.PASS, "Able to add product in cart");
			ExtentUtils.pass(driver, test,"Able to add product in cart", logger);
		} else {
			ExtentUtils.fail(driver, test, "Couldn't able to add product", logger);
			Assert.assertTrue(false);
		}
	}
}
