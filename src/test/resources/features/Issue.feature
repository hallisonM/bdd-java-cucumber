@IssueFeature
Feature: Issue

  Background: Login successfuly
    Given I am on the login page
    When I enter correct credentials
    Then Home page should be shown

  @IssueSuccessfuly
  Scenario: Create Issue Successfuly
    Given I click on Report Issue button
      When I select project
      And I fill in the form with the necessary data
      Then I see Issues Page
      And I see the record in the first row of the table

