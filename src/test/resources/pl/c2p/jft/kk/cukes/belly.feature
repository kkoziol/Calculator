Feature: Adding

  Scenario: Simple adding
    Given I Just switch on my calculator
    When I click button 1
    When I click button +
    When I click button 1
     And I click button =
    Then I should see on display number 2.0

  Scenario: Multiple adding
    Given I Just switch on my calculator
    When I click button 1
    When I click button +
    When I click button 1
    When I click button +
    When I click button 1
    When I click button +
    When I click button 1
    And I click button =
    Then I should see on display number 4.0

  Scenario: Multiple adding with intermediate results check
    Given I Just switch on my calculator
    When I click button 1
    When I click button +
    When I click button 1
    When I click button +
    Then I should see on display number 2.0
    When I click button 1
    When I click button +
    When I click button 1
    And I click button =
    Then I should see on display number 4.0