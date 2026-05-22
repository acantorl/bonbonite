@E2E @Account @Password
Feature: Change password

  @SuccessfulPasswordChange @Security
  Scenario: Successful change and reset of password
    Given that the user navigates to the online store
    When he logs in with credentials "1414141414" and "123456789Aa..@"
    And change your password from "123456789Aa..@" to "NuevaClave2026."
    And he logs out
    Then you should see a message identical to "Ingresa a tu cuenta"
    And he logs in with credentials "1414141414" and "NuevaClave2026."
    And resets the password from "NuevaClave2026." back to "123456789Aa..@"
    And he logs out