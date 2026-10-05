Feature: Login to SauceDemo

  Scenario: Login with valid credentials
    Given I am on the SauceDemo login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be successfully logged in

  Scenario: Login with invalid password
    Given I am on the SauceDemo login page
    When I enter username "standard_user"
    And I enter password "wrong_password"
    And I click the login button
    Then I should see a login error message

  Scenario: Login with empty username
    Given I am on the SauceDemo login page
    When I enter username ""
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see a login error message

  Scenario: Login with empty password
    Given I am on the SauceDemo login page
    When I enter username "standard_user"
    And I enter password ""
    And I click the login button
    Then I should see a login error message

  Scenario: Login with locked out user
    Given I am on the SauceDemo login page
    When I enter username "locked_out_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see a login error message