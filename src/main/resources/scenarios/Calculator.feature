Feature: Amazon App Test

  @Test1
  Scenario: Calculator test
    When user clicks on "2"
    And user clicks on "add"
    And user clicks on "2"
    And user clicks on "equals"
    Then user verifies the result "4"