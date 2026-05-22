@E2E @Shopping @Cart
Feature: Add product to cart

  @SuccessfulAddToCart @Smoke
  Scenario: Successful addition of product to cart
    Given that the user navigates to the online store
    When the user search for the product "tenis"
    And adds the product to the cart
    Then the PLP page should display the message "se ha añadido a tu carrito.."
