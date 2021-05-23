Feature: create new contact

  Background:
    Given I am authorized

  Scenario Outline:
    Given I am on Contact create page
    When I fill Last Name field
    And I fill First Name field
    And I select company name
    And I fill Job title
    And I click save and close button
    Then I see success message
    Examples:
      | test1 |