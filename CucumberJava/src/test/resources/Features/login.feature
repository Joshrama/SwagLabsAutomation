@regression
Feature: purchase the most product at swaglabs

  @SwagLabs
  Scenario: Purchase the most expensive product
    Given user access the website login page
    When user enter valid username and password
    And user clicks on login button
    Then user should be navigated to the products page
    When user sort products by the highest price
    And user verify that the products have the highest price
    And user click on the add to cart button for the most expensive product
    And user click on the shopping cart badge
    Then user should be navigated to the cart page
    When user verify that the correct product is added to the cart
    And user click on the checkout button
    Then user should be navigated to the checkout step one page
    When user enter the required details on checkout page
    And user click the continue button
    Then user should be navigated to the checkout step two page
    When user verify the order status
    And user click the finish button
    Then user should be navigated to the checkout complete page
    Then user capture the screen
