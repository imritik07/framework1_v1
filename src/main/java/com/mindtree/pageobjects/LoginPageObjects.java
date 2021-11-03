package com.mindtree.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {
	@FindBy(xpath = "//li[@class='site-header-account-link']")
	public static WebElement login;

//	@FindBy(xpath="//span[@class='remodal-form-control']//input[@name='customer[email]']")
	@FindBy(id = "customer_email")
	public static WebElement email;

	// @FindBy(xpath=
	// "//span[@class='remodal-form-control']//input[@name='customer[password]']")
	@FindBy(id = "customer_password")
	public static WebElement pass;

//	@FindBy(css= "button.remodal-submit")
	@FindBy(css = "button.button-primary.form-action--submit.mdc-ripple-surface.mdc-ripple-upgraded")
	public static WebElement loginbtn;
}
