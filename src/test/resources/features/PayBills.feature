@Pay_Bills
Feature: Pay Bills
  As a user , i want to be able to receive message when i make payment successfully.

  Background:
    Given user is on the landing page
    And user clicks on the Singin button
    And user logs in with "username" and "password"
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
