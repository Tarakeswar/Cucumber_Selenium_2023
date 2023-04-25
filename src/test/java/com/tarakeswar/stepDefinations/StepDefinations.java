package com.tarakeswar.stepDefinations;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.tarakeswar.pageObjects.AddCustomerPage;
import com.tarakeswar.pageObjects.LoginPage;
import com.tarakeswar.pageObjects.SearchCustomerPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations extends BaseClass {

	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
		logger=Logger.getLogger("Cucumber_Selenium_2023");
		PropertyConfigurator.configure("./Log4j.properties");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.whitelistedIps", "");

		driver = new ChromeDriver(options);
		logger.info("************ Launching the browser*************");
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);

	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		logger.info("************ Launching the "+url+"*************");

	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {

		loginPage.setUserName(email);
		logger.info("************ Enetering username as"+email+"*************");
		loginPage.setPassword(password);
		logger.info("************ Enetering password as"+password+"*************");
	}

	@When("click on login")
	public void click_on_login() {
		loginPage.clickOnLogin();
		logger.info("************ clicking on sign in button *************");

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {

		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
			logger.info("************ login passes *************");
		}
		Assert.assertEquals(title, driver.getTitle());
		logger.info("************ login passes *************");

	}

	@When("user clicks on the logout link")
	public void user_clicks_on_the_logout_link() throws InterruptedException {
		loginPage.clickOnLogout();
		logger.info("************ clicking on logout link *************");
		Thread.sleep(3000);
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		logger.info("************ closing the browser *************");
	}

	// Add customer step definition

	@Then("user can view dashboard")
	public void user_can_view_dashboard() {
		customerPage = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", customerPage.getTitle());
	}

	@When("user clicks on the customer menu")
	public void user_clicks_on_the_customer_menu() throws InterruptedException {
		Thread.sleep(5000);
		customerPage.clickOnCustomerMenu();
		logger.info("************ clicking on the customer menu *************");

	}

	@When("click on customers menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(5000);
		customerPage.clickOnCustomerMenuItem();
		
		logger.info("************ clicking on the customer menu item *************");

	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(3000);
		customerPage.clickOnAddNew();
		
		logger.info("************ clicking on the add new customer button *************");
	}

	@Then("user can view add customer new page")
	public void user_can_view_add_customer_new_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", customerPage.getTitle());
	}

	@When("user enters customer information")
	public void user_enters_customer_information() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		customerPage.setEmail(email);
		customerPage.setPassword("Test@123");
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		// Add the customer to 'Guests' or 'Registered' customer role
		customerPage.selectCustomerRoles("Guest");
		Thread.sleep(3000);
		customerPage.setFirstName("Tarak");
		customerPage.setLasttName("Pradhan");
		customerPage.setGender("Male");
		customerPage.setDOB("11/05/1990"); // Format: D/MM/YYY
		customerPage.setCompanyName("busyQA");
		//customerPage.setNewsLetter("Test store 2");
		//customerPage.setManagerForVendor("Vendor 2");
		customerPage.setAdminComment("This is for testing.........");
		logger.info("************ customer information is added *************");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		customerPage.clickOnSave();
		Thread.sleep(3000);
		logger.info("************ clicking on the save button *************");
	}

	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
		logger.info("************ Verified the successful message *************");

	}
	
	//steps for Search a customer using email id
	
	@When("enter customer email")
	public void enter_customer_email() {
		searchPage=new SearchCustomerPage(driver);
		searchPage.setEmail("victoria_victoria@nopCommerce.com");
		logger.info("************ Entering the email *************");
	}
	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchPage.clickOnSearch();
		logger.info("************ clicking the seach button *************");
		Thread.sleep(3000);
	}
	@Then("user should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean emailStatus=searchPage.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(emailStatus, true);
	}
	
	//Search customer by name 
	
	@When("enter customer Firstname")
	public void enter_customer_Firstname() {
		searchPage=new SearchCustomerPage(driver);
		searchPage.setFirstName("Victoria");
		logger.info("************ Entering the firstname *************");
	}
	
	@When("enter customer Lastname")
	public void enter_customer_Laststname() {
		searchPage.setLastName("Terces");
		logger.info("************ Entering the lastname *************");
	}
	@Then("user should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=searchPage.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}

}
