Feature: Compare repositories in UI and through API

  @test
  Scenario: To perform comparison of list of repositories and their description
    Given I am on the landing page of Django github repo
    And I click on repositories option
    Then I should be able to see and capture all the listed repositories and their description
    Then I compare the values against the values received through API response