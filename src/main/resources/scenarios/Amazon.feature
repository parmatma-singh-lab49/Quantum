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

  @AndroidTest3
  Scenario: Android test - Multiple items add/remove flow
    When user selects "English" language preference
    And user selects "Skip sign in" option
    And enters "Iphone" in the search box
    And user clicks "Apple iPhone XR (64GB) - White" product
    And user clicks on "Enter an Indian pincode" button
    And user enters "834002" value as pincode
    And user clicks on "Apply" button
    And user clicks "Black" option
    And user clicks "128GB" option
    And user clicks "Add to Cart" option
    And user clicks on "DONE" button
    And user clicks on search icon
    And enters "Oneplus" in the search box
    And user clicks "OnePlus Nord 2 5G (Blue Haze, 8GB RAM, 128GB Storage)" product
    And user clicks "Add to Cart" option
    And user clicks on cart icon
    And user validates the total cart value "70,998.00"


