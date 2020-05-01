@Pay_Bills
Feature: Pay Bills
  As a user , i want to be able to receive message when i make payment successfully.

  Background:
    Given user is on the landing page
    When user  logs in with valid credentials
    Then user navigates to "Pay Bills"

  Scenario: user should be able make payment and receive verification message
    And User should verify the title is "Zero - Pay Bills"
    When user enter date and amount
      | amount | 100        |
      | date   | 2020-04-08 |
    Then user click on the pay button
    And user should verify the "The payment was successfully submitted." message is displayed
    Then user logs out


  Scenario: user should be able receive error message payment when use invalid data
    When user enter date and amount
      | amount | 100$        |
      | date   | 2020-may-08 |
    Then user click on the pay button
    And user should verify the "Please fill out this field message!" message is displayed
    Then user logs out

  @AddNew_Payee
  Scenario: Add new Payee
    When user access navigates to "Add New Payee"
    And user creates new payee using following information
      | Payee Name    | The Law Office Of Hyde, Price % Scharks |
      | Payee Address | 100 Same st, Anytown, USA,10001         |
      | Account       | Checking                                |
      | Payee Details | XYZ account                             |
    Then user click on the add button
    And user verify   "The new payee The Law Office Of Hyde, Price % Scharks was successfully created."  displayed

  @Foreign_Currency
  Scenario: Available currencies
    When user access navigates to "Purchase Foreign Currency"
    Then user verifies following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Singapore (dollar)    |
    Then user logs out

  @error-message
  Scenario Outline: Purchase Foreign Currency error message
    When user access navigates to "Purchase Foreign Currency"
    When user enters currency "<currency>"
    And user enters amount "<amount>"
    Then user select radioButton
    And user click on Purchase
    Then user verifies error message is displayed "Please, ensure that you have filled all the required fields with valid values."
    Then user logs out
    Examples:
      | currency        | amount |
      | Canada (dollar) |        |
      | Select One      | 100    |


