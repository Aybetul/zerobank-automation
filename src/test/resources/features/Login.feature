Feature:Login
  As user, I want to be able to login with user and password

  Background:open login page
    Given user is on the landing page

    @valid_credentials
    Scenario: user logs in with valid credentials
      When user  logs in with valid credentials

  Scenario: Login with valid credentials and verify Account summary page displayed
    And user clicks on the Singin button
    When user logs in with "username" and "password"
    Then user should verify the page is "Account Summary"
   # Then user logs out


  Scenario Outline: Login with invalid <username> and <password> and verify <error message> is displayed
    And user clicks on the Singin button
    When user logs in with "<username>" and "<password>"
    Then user should verify the "<error message>" is displayed
    Examples:credentials
      | username  | password      | error message                    |
      | wrongName | wrongPassword | Login and/or password are wrong. |
      |           |               | Login and/or password are wrong. |
      | wrong123  |               | Login and/or password are wrong. |
      |           | wrong123      | Login and/or password are wrong. |