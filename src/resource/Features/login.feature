Feature: Login

  Scenario Outline: Login page with valid credentials

    Given the web application "nopcommerce" is launched in "NewWindow"
    When the user enters the value "<username>" into userid textbox at NopcommerceLoginPage page
    And the user enters the value "<pwda>" into the password texbox at NopcommerceLoginPage page
    And the user click on log in element at NopcommerceLoginPage page
    Then user validates the pagetitle "Homepage" is displayed

    Examples:
      |username|pwda|
      |admin@yourstore.com|admin|
