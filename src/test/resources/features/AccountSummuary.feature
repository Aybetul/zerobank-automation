@Account_Summary
Feature:Account Summary
  As user, i want to verify the available account types

  Background:
    Given user is on the landing page
    And user clicks on the Singin button
    And user logs in with "username" and "password"

  Scenario: user on the Account summary page and verifies following options
    Then user verify following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then user logs out

  Scenario: user verifies the Credit Accounts Headers
    Then user should verify following options
      | Account     |
      | Credit Card |
      | Balance     |
    Then user logs out

  Scenario: User verify the title
    Then User should verify the title is "Zero - Account Summary"
    Then user logs out

  @redirect
  Scenario Outline: saving account redirect
    When user clicks on the "<linkToClick>"
    Then user should verify the page is "<Tab>"
    And user verify default option should be "<linkToVerify>"
    Then user logs out
    Examples:Credentials
      | linkToClick | Tab              | linkToVerify |
      | Savings     | Account Activity | Savings      |
      | Brokerage   | Account Activity | Brokerage    |
      | Checking    | Account Activity | Checking     |
      | Credit Card | Account Activity | Credit Card  |
      | Loan        | Account Activity | Loan         |


