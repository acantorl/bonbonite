@E2E @Account @Password
Feature: Change password

  @SuccessfulPasswordChange @Security
  Scenario: Successful change and reset of password
    Given that the user navigates to the online store
    When he logs in with credentials "12345678900" and "12345678900Aa.."
    And change your password from "12345678900Aa.." to "NuevaClave2026."
    And he logs out
    Then you should see a message identical to "Ingresa a tu cuenta"
    And he logs in with credentials "12345678900" and "NuevaClave2026."
    And resets the password from "NuevaClave2026." back to "12345678900Aa.."
    And he logs out