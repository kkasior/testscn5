Feature: podcast
  Scenario: launching first podcast
    Given I am on the main dev.to page
    When I click the podcasts button
    And I select the first podcast from list
    And I clik on the play button
    Then I should be able to listen to the podcast