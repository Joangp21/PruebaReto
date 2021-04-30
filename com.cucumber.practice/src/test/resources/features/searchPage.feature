Feature: Search page Test Case
  I want to search an existing page

@Scenario2
  Scenario: Validating search page 
    Given I press pages option 
    And I make sure Pages page is displayed
    When I type a page on the serch pages field
    And I press search pages buttom
    Then I see the results