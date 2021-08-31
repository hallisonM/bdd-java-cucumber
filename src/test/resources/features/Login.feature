@LoginFeature
Feature: Login

  Background: Access de Login Page
      Given I am on the login page

    @InvalidLogin
    Scenario Outline: Invalid Login
    When I enter wrong credentials
    And I click on Login button
    Then <message> should be shown
    Examples:
    |message|
    |"Your account may be disabled or blocked or the username/password you entered is incorrect."|

    @LoginSuccessfuly
    Scenario: Login Successfuly
      When I enter correct credentials
      Then Home page should be shown