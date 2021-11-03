package com.mindtree.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageobjects.HomePageObjects;

public class HomePageUI extends HomePageObjects {
	WebDriver ldriver;
	
	public HomePageUI(WebDriver driver){
		this.ldriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchAProduct(String name){
		searchBox.sendKeys(name);
	}
	public void clickSearch(){
		searchIcon.click();
	}
	public WebElement getSelector() {
		return selector;
	}
	public void clickOnSelector() {
		selector.click();
	}
	public void clickOnAddCartBtn() {
		addToCartBtn.click();
	}
	public WebElement getHeading() {
		return addedToCart;
	}
	public void clickOnProduct() {
		selectedProduct.click();
	}
	public void clickOnProductBookSet() {
		productBookSet.click();
	}
	public String getBookSetPrice(){
		return bookSetPrice.getText();
	}
	public String getBookSetDiscount(){
		return bookSetDiscount.getText();
	}
}
