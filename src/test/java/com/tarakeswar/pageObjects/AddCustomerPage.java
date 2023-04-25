package com.tarakeswar.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	public WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By customer_link_menu = By.xpath("//li[a[@href='/Admin']]/following-sibling::li[3]/a");
	By customer_link_menu_Item = By.xpath("//a[contains(@href,'Admin/Customer/List')]/p");

	By addNewCustomerBtn = By.xpath("//a[@class='btn btn-primary']/i");

	By listItemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By listItemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By listItemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By listItemVendors = By.xpath("//li[contains(text(),'Vendors')]");

	By enterEmail = By.xpath("//input[@id='Email']");
	By enterPassword = By.id("Password");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By gender_male = By.id("Gender_Male");
	By gender_Female = By.id("Gender_Female");
	By dateOfBirth = By.xpath("//input[@id='DateOfBirth']");
	By company_name = By.id("Company");
	By isTaxExempt = By.id("IsTaxExempt");
	By newsLetter = By.id("SelectedNewsletterSubscriptionStoreIds");
	By customerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	By mngOfVendor = By.xpath("//*[@id='VendorId']");
	By setComment = By.xpath("//textarea[@id='AdminComment']");
	By saveBtn = By.xpath("//button[@name='save']/i");

	// Action Methods

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickOnCustomerMenu() {
		driver.findElement(customer_link_menu).click();
	}

	public void clickOnCustomerMenuItem() {
		driver.findElement(customer_link_menu_Item).click();
	}

	public void clickOnAddNew() {
		driver.findElement(addNewCustomerBtn).click();
	}

	public void setEmail(String email) {
		driver.findElement(enterEmail).sendKeys(email);
	}

	public void setPassword(String password) {
		driver.findElement(enterPassword).sendKeys(password);
	}

	public void selectCustomerRoles(String role) throws InterruptedException {
		if (role != ("Vendors")) {
			driver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		driver.findElement(customerRoles).click();

		WebElement listItem;
		Thread.sleep(3000);

		if (role.equals("Administrators")) {
			listItem = driver.findElement(listItemAdministrators);
		} else if (role.equals("Guests")) {
			listItem = driver.findElement(listItemGuests);
		} else if (role.equals("Registered")) {
			listItem = driver.findElement(listItemRegistered);
		} else if (role.equals("Vendors")) {
			listItem = driver.findElement(listItemVendors);
		} else {
			listItem = driver.findElement(listItemGuests);
		}
		// listItem.click();
		// Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", listItem);
	}

	public void setManagerForVendor(String value) {
		Select sel = new Select(driver.findElement(mngOfVendor));
		sel.selectByValue(value);
	}
	
	public void setNewsLetter(String value) {
		Select sel = new Select(driver.findElement(newsLetter));
		sel.selectByValue(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			driver.findElement(gender_male).click();
		} else if (gender.equals("Female")) {
			driver.findElement(gender_Female).click();
		} else {
			driver.findElement(gender_male).click();
		}
	}

	public void setFirstName(String firstname) {
		driver.findElement(firstName).sendKeys(firstname);
	}

	public void setLasttName(String lastname) {
		driver.findElement(lastName).sendKeys(lastname);
	}

	public void setDOB(String dob) {
		driver.findElement(dateOfBirth).sendKeys(dob);
	}

	public void setCompanyName(String company) {
		driver.findElement(company_name).sendKeys(company);
	}

	public void setAdminComment(String comment) {
		driver.findElement(setComment).sendKeys(comment);
	}

	public void clickOnSave() {
		driver.findElement(saveBtn).click();
	}

}
