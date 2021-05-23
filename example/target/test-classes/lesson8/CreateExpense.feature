Feature: create expense

Background:
Given I am authorized

Scenario Outline:
Given I am on expense page
When I fill '<description>' field
And I select business unit
And I select expense
And I fill sum plan
And I select date
And I click save and close button
Then I see success message
Examples:
| description |
| test1       |
| test2       |