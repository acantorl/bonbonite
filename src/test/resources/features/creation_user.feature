@E2E @Registration
Feature: Create user

  @SuccessfulRegistration
  Scenario: Successful user creation with random data
    Given that the user navigates to the online store
    When they register a user account
    Then the orders section must indicate "No has realizado ningún pedido aún"