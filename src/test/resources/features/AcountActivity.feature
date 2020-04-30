@Account_Activity
Feature:Account Activity
  As a user i want to verify account drop down options


  Background:
    Given user is on the landing page
    And user clicks on the Singin button
    And user logs in with "username" and "password"
    Then user navigates to "Account Activity"

  Scenario: User verify the title
    Then User should verify the title is "Zero - Account Activity"
    Then user verify default option should be "Savings"
    And  User clicks on the drop down
    Then user verifies following drop down options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then user verifies transactions table have following names
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
    Then user logs out

  @date_range
  Scenario: Search date range
    When user access navigates to "Find Transactions"
    Then user enter the date range "2012-09-01" and "2012-09-06"
    When click on find
    And result table should display only date range "2012-09-01" and "2012-09-06"
    And verify result sorted by most recent date
    Then user logs out

  @date_range
  Scenario: Search date range2
    When user access navigates to "Find Transactions"
    Then user enter the date range "2012-09-02" and "2012-09-06"
    When click on find
    Then verify the the date list not contains "2012-09-01"
    Then user logs out

  @Search_description
  Scenario Outline:Search description
    When user access navigates to "Find Transactions"
    Then user enters description "<description>"
    When click on find
    Then verify result table should show only containing "<result>"
    Then user logs out
    Examples:
      | description | result |
      | OFFICE      | OFFICE |
      | ONLINE      | ONLINE |

  @Search_description
  Scenario Outline: Search description case insensitive
    When user access navigates to "Find Transactions"
    Then user enters description "<description>"
    When click on find
    Then  verify system display "<message>"
    Then user logs out
    Examples:
      | description | message     |
      | online      | No results.  |
      | Office      | No results. |


