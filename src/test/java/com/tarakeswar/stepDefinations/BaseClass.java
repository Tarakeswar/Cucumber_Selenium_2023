package com.tarakeswar.stepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.tarakeswar.pageObjects.AddCustomerPage;
import com.tarakeswar.pageObjects.LoginPage;
import com.tarakeswar.pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public AddCustomerPage customerPage;
	public SearchCustomerPage searchPage;
	public static Logger logger;
	
	//created to get random string for unique email id
	public static String randomString()
	{
	String generatedString=RandomStringUtils.randomAlphabetic(7);
	return generatedString;
	}

}
