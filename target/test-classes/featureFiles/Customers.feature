Feature: Customers

  Background: Below are the common step for each scenario.
    Given user launch chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then user can view dashboard

@sanity
  Scenario: Add a new customer
    When user clicks on the customer menu
    And click on customers menu Item
    And click on Add new button
    Then user can view add customer new page
    When user enters customer information
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully."
    And close the browser
@regression
  Scenario: Search Customer by EmailID
    When user clicks on the customer menu
    And click on customers menu Item
    And enter customer email
    When click on search button
    Then user should found email in the search table
    And close the browser
@sanity
  Scenario: Search Customer by Name
    When user clicks on the customer menu
    And click on customers menu Item
    And enter customer Firstname
    And enter customer Lastname
    When click on search button
    Then user should found name in the search table
    And close the browser
