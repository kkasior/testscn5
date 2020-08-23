Feature:calculator
  Scenario: adding two numbers
    Given I have a calculator
    When I add 2 and 3
    Then I should get 5

  Scenario: subtract two numbers
    Given I have a calculator
    When I subtract 2 from 3
    Then I should get 1