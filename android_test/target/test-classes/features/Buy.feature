Feature: buy the following product
  - Item: Sauce Lab Back Packs
  - Color: Blue
  - Quantity: 2 items

  Scenario: User pick the item they want to buy
    Given User already on catalog page
    When User select an item Sauce Lab Back Packs
    Then User should see Product Highlights page

  Scenario: User chose what they want to buy
    Given User already on catalog page
    And User select an item Sauce Lab Back Packs
    When User select the blue color
    Then User should see indicator when color is selected

  Scenario: User pick 2 items
    Given User already on catalog page
    And User select an item Sauce Lab Back Packs
    And User select the blue color
    When User add one more item
    And Click on button Add to cart
    Then User should see number of items in their cart

  Scenario: User checkout the items from the cart
    Given User already on catalog page
    And User select an item Sauce Lab Back Packs
    And User select the blue color
    And User add one more item
    And Click on button Add to cart
    When User click on icon cart
    And Verify quantity and total price of items
    And User click on button Proceed To Checkout
    Then User should see login page to login and continue checkout
