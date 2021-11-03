package com.mindtree.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BlogReaderPageObjects {
	// xpath="//li[@class='search-flydown--quicklinks-item']//a[@href='/blogs/articles']"
	@FindBy(linkText = "Our Blog")
	public static WebElement lnkBlog;

	@FindBy(xpath = "//a[@href='/blogs/articles/why-do-we-celebrate-holi']")
	@CacheLookup
	public static WebElement lnkToHoliBlog;

	@FindBy(xpath = "//div[@class='article--content rte']")
	@CacheLookup
	public static WebElement getContent;

	@FindBy(id = "article_comment_author")
	@CacheLookup
	public static WebElement uname;

	@FindBy(css = "#article_comment_email")
	@CacheLookup
	public static WebElement email;

	@FindBy(css = "#article_comment_message")
	@CacheLookup
	public static WebElement message;

	@FindBy(css = "button.button-primary.mdc-ripple-surface.mdc-ripple-upgraded")
	@CacheLookup
	public static WebElement submitCmt;
}
