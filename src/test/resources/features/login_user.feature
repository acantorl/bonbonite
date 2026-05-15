@E2E @Auth
Feature: Login

  @SuccessfulLogin @Smoke @Regression
  Scenario Outline: Successful Login with existing credentials
    Given that the user navigates to the online store
    When he logs in with credentials "<user>" and "<password>"
    Then he should see a message related to "<expected_message>"

    Examples:
      | user      | password        | expected_message                   |
      | 12345678900 | 12345678900Aa.. | No has realizado ningún pedido aún |