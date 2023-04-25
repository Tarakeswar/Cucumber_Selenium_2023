package com.tarakeswar.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement textemail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement textpassword;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginBtn;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logoutLink;

	public void setUserName(String username) {
		textemail.clear();
		textemail.sendKeys(username);
	}

	public void setPassword(String password) {
		textpassword.clear();
		textpassword.sendKeys(password);
	}

	public void clickOnLogin() {
		loginBtn.click();
	}

	public void clickOnLogout() {
		logoutLink.click();
	}

}
