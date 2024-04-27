Feature: Customers
  Scenario: Add a customer
    Given the web application "nopcommerce" is launched in "NewWindow"
    When the user enters the value "admin@yourstore.com" into userid textbox at NopcommerceLoginPage page
    And the user enters the value "admin" into the password texbox at NopcommerceLoginPage page
    And the user click on log in element at NopcommerceLoginPage page
    Then user validates the pagetitle "Homepage" is displayed
    When user click on customer menu
    And user click on customer menu option
    And user click on addnew button
    And fill the customer info
    Then user can see confirmation message "new customer added successfully"
    And close browser
