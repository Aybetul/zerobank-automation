Feature: Statements and Documents details

  Background:
    Given user is on the landing page
    When user  logs in with valid credentials
    Then user navigates to "Online Statements"

@DataTable
  Scenario Outline: Resent statements per year
    When user select the Resent statement "<year>"
    Then verify "<count>" statements should be displayed for that "<year>"
    Then user logs out
    Examples:
      | year | count |
      | 2009 | 2     |
      | 2010 | 2     |
      | 2011 | 2     |
      | 2012 | 1     |
