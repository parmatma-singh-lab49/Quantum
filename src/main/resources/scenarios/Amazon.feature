Feature: Amazon App Test

@AndroidTest1
Scenario: Android test
#Given user is performing test on "Android"
  When user selects "English" language preference
  And user selects "Skip sign in" option
  And enters "Iphone" in the search box
  Then user verifies "Apple iPhone XR (64GB) - White" product is displayed

  @WebTest1
  Scenario: Amazon Web Test
    When User launches url "https://www.amazon.in" on browser
    And user enters "Iphone" in the search box on web
    Then user verifies "Apple iPhone XR (64GB) - White" product is displayed on web

  @AndroidTest2
  Scenario: Android test - E2E flow
#Given user is performing test on "Android"
    When user selects "English" language preference
    And user selects "Skip sign in" option
    And enters "Iphone" in the search box
    Then user verifies "Apple iPhone XR (64GB) - White" product is displayed
    And user clicks "Apple iPhone XR (64GB) - White" product
    And user clicks on "Enter an Indian pincode" button
    And user enters "834002" value as pincode
    And user clicks on "Apply" button
    And user clicks on "Add to Cart" button
    And user clicks on "Cart" button
    And user validates the total cart value "34,999.00"


