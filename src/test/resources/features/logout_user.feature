@E2E @Auth
Feature: Logout

  @SuccessfulLogout @Sanity @Regression
  Scenario Outline: Successful Logout with Existing Data
    Given that the user navigates to the online store
    When he logs in with credentials "<user>" and "<password>"
    And he logs out
    Then he should see a header message related to "<expected_message>"

    Examples:
      | user      | password        | expected_message                     |
      | 12345678900 | 12345678900Aa.. | Hecho a mano en Colombia desde 1979 |