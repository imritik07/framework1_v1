package com.mindtree.uistore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.mindtree.pageobjects.BlogReaderPageObjects;

public class BlogReaderUI extends BlogReaderPageObjects {

WebDriver ldriver;
	public BlogReaderUI(WebDriver driver){
		this.ldriver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLinkBlog() {
		lnkBlog.click();
	}
	public void clickLinkToHoliBlog() {
		lnkToHoliBlog.click();
	}
	public String getParaContent() {
		return getContent.getText();
	}
	public void setEmail(String aemail) {
		email.sendKeys(aemail);
	}
	public void setName(String aname) {
		uname.sendKeys(aname);
	}
	public void setMessage(String cmt) {
		message.sendKeys(cmt);
	}
	public void clickSubmitComment() {
		submitCmt.click();
	}
}
