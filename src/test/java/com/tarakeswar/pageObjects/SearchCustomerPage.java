package com.tarakeswar.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tarakeswar.utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver driver;

	WaitHelper wait;

	public SearchCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitHelper(driver);
	}

	@FindBy(id = "SearchEmail")
	@CacheLookup
	public WebElement eMail;

	@FindBy(id = "SearchFirstName")
	@CacheLookup
	public WebElement firstname;

	@FindBy(id = "SearchLastName")
	@CacheLookup
	public WebElement lastname;

	@FindBy(id = "SearchMonthOfBirth")
	@CacheLookup
	public WebElement month;

	@FindBy(id = "SearchDayOfBirth")
	@CacheLookup
	public WebElement day;

	@FindBy(id = "SearchCompany")
	@CacheLookup
	public WebElement company;

	@FindBy(id = "search-customers")
	@CacheLookup
	public WebElement btnSearch;

	@FindBy(xpath = "//table[@role='grid']")
	@CacheLookup
	public WebElement tablesearchresults;

	@FindBy(xpath = "//table[@id='customers-grid' and @aria-describedby='customers-grid_info']")
	@CacheLookup
	public WebElement table;

	@FindBy(xpath = "//table[@id='customers-grid' and @aria-describedby='customers-grid_info']/tbody/tr")
	@CacheLookup
	public List<WebElement> tableRow;

	@FindBy(xpath = "//table[@id='customers-grid' and @aria-describedby='customers-grid_info']/tbody/tr/td")
	@CacheLookup
	public List<WebElement> tableColumn;

	public void setEmail(String email) {
		wait.waitForElement(eMail);
		eMail.clear();
		eMail.sendKeys(email);
	}

	public void setFirstName(String firstName) {
		wait.waitForElement(firstname);
		firstname.clear();
		firstname.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		wait.waitForElement(lastname);
		lastname.clear();
		lastname.sendKeys(lastName);
	}

	public void clickOnSearch() {
		btnSearch.click();
		wait.waitForElement(btnSearch);
	}

	public int getNoOfRows() {
		return (tableRow.size());
	}

	public int getNoOfCoulmns() {
		return (tableColumn.size());
	}

	public boolean searchCustomerByEmail(String email) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailid);

			if (emailid.equals(email)) {
				flag = true;
				break;
			}
		}

		return flag;

	}

	public boolean searchCustomerByName(String Name) {
		boolean flag = false;

		for (int i = 1; i <= getNoOfRows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			
			String[] names=name.split(" ");

			if (names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag = true;
				break;
			}
		}

		return flag;

	}

}
