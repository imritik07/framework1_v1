package com.mindtree.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageobjects.LoginPageObjects;

public class LoginPageUI extends LoginPageObjects {
	WebDriver ldriver;

	public LoginPageUI(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickLoginLink() {
		login.click();
	}

	public void setEmail(String em) {
		email.sendKeys(em);
	}

	public void setPass(String ps) {
		pass.sendKeys(ps);
	}

	public void clickLoginBtn() {
		loginbtn.click();
	}
}
