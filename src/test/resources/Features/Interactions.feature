Feature: Interact with multiple elements on page.

  Scenario: Login as a Standard User.
    Given user navigates to the main page
    And the user enters a valid username and password
    When user clicks on Login button
    Then the user is logged in


  Scenario: Login as a Standard User and complete a purchase.
    Given user navigates to the main page
    And the user enters a valid username and password
    When user clicks on Login button
    Then the user is logged in
    And the user adds a product to cart
    And verifies that the desired quantity of products is added to the cart
    When the user proceed to checkout and fills all the billing data
    And verifies all the final details
    Then the purchase is complete.


