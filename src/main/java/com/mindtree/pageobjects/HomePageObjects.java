package com.mindtree.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {
	@FindBy(css = "input.form-field-input.live-search-form-field")
	public static WebElement searchBox;
	
	@FindBy(css="button.live-search-button.mdc-ripple-surface.mdc-ripple-upgraded")
	public static WebElement searchIcon;
	
	@FindBy(xpath ="//h2[@class='productitem--title'][1]")
	public static WebElement selectedProduct;
	
	@FindBy(id="product-quantity-select")
	public static WebElement selector;
	
	@FindBy(css="button.product-form--atc-button.mdc-ripple-surface.mdc-ripple-upgraded")
	public static WebElement addToCartBtn;
	
	@FindBy(css="h2.atc-banner--product-title")
	public static WebElement addedToCart;
	
	@FindBy(xpath="//a[@href='/products/elocalshop-box-10-books']")
	public static WebElement productBookSet;
	
	@FindBy(css="span.money")
	public static WebElement bookSetPrice;
	
	@FindBy(css="span.product--badge.badge--sale")
	public static WebElement bookSetDiscount;
}
