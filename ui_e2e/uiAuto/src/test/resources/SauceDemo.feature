Feature: End to End Test Case

  Scenario: Buy three items into SauceDemo page
    Given I open SauceDemo page
    And I login with "standard_user" with password "secret_sauce"
    When I add the follow items to the card
      | Sauce Labs Backpack |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Bike Light |
    And I go to the cart
    And I complete my buy with "First Name" as First Name, "Last Name" as Last Name and "0000" as zip code
    Then I verify the "Thank you for your order!" is displayed at the end of the buy