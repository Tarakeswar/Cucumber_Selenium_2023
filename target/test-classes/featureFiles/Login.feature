Feature: Login

  Scenario: Successful login with valid credentials
    Given user launch chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on the logout link
    Then page title should be "Your store. Login"
    And  close the browser
    
    Scenario Outline: Login Data driven
    Given user launch chrome browser
    When user opens URL "https://admin-demo.nopcommerce.com/login"
    And user enters email as "<email>" and password as "<password>"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user clicks on the logout link
    Then page title should be "Your store. Login"
    And  close the browser
    
    Examples:
    |email | password |
    |admin@yourstore.com|admin|
    |admin1234@yourstore.com|admin|
