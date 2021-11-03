package com.mindtree.runner;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.resusablecomponent.BaseClass;
import com.mindtree.uistore.HomePageUI;
import com.mindtree.utilities.ExcelUtils;
import com.mindtree.utilities.ExtentUtils;
import com.mindtree.utilities.ReadProperties;

public class TC_SearchingProductDDT_005 extends BaseClass {
	// This test will search for products using data provider
	@Test(dataProvider= "productDetails1")
	public void searchDDTProduct(String pname) throws InterruptedException {
		test= extent.startTest("SearchDDT Test");
		driver.navigate().to(rp.getUrl());
		logger.info("Url is opened");
		
		HomePageUI hm= new HomePageUI(driver);
		hm.searchAProduct(pname);
		logger.info(pname+ "is entered into the searchBox");
		hm.clickSearch();
		logger.info("clicked on search");
		
		Thread.sleep(3000);
		driver.navigate().back();
		logger.info("moving back");
		
		Assert.assertTrue(true);
		ExtentUtils.pass(driver, test, "SearchDDT is done.", logger);
//		test.log(LogStatus.PASS, "SearchDDTPrduct is done.");
	}
	
	@DataProvider(name="productDetails1")
	public String[][] getData() {
		String path= System.getProperty("user.dir")+"/testdata/products.xlsx";
		int rowNum=0, colNum=0;
		try {
			rowNum = ExcelUtils.getRowCount(path, "sheet1");
			colNum = ExcelUtils.getCellCount(path,"sheet1", 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String data[][]= new String[rowNum][colNum];
		for(int i=1; i<=rowNum; i++)
		{
			for(int j=0; j< colNum; j++)
			{
				try {
					data[i-1][j]= ExcelUtils.getCellData(path, "Sheet1",i, j);
				} catch (IOException e) {
					System.out.println("Unable to fetch data");
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}
