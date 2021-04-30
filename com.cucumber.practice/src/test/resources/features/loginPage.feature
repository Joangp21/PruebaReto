Feature: Login Test Case
  I want to validate login page with valid credentials

@Scenario1
  Scenario: Validating login page with valid credentials
    Given I want to open login page
    And I make sure login page is displayed
    When I type my username and password on login page
    And I press login buttom
    Then I assert I get the form successfully
    And I press logout buttom