Feature: create new project

  Background:
    Given I am authorized

  Scenario Outline:
    Given I am on create Project page
    When I fill Project Name field
    And I select Organization Name
    And I select business unit
    And I select Project Curator
    And I select Project Lead
    And I select Project Administrator
    And I select Project Manager
    And I click save and close button
    Then I see success message
    Examples:
      | test1 |