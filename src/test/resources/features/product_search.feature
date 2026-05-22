@E2E @Search
Feature: Check product availability

  @SuccessfulSearch @Sanity
  Scenario Outline: Successful product search for different categories
    Given that the user navigates to the online store
    When the user search for the product "<product>"
    Then the user should see results related to "<expected_filter>"

    Examples:
      | product | expected_filter |
      | tenis   | Filtros         |
      | bolso   | Filtros         |