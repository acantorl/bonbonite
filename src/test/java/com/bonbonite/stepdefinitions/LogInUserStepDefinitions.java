package com.bonbonite.stepdefinitions;

import com.bonbonite.tasks.LogInUser;
import com.bonbonite.userinterfaces.MyAccountPageUI;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static org.hamcrest.Matchers.containsString;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogInUserStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }



    @When("he logs in with credentials {string} and {string}")
    public void heLogsInWithCredentialsAnd(String cedula, String password) {
        theActorInTheSpotlight().attemptsTo(
                LogInUser.conCredenciales(cedula, password)
        );
    }

    @Then("he should see a message related to {string}")
    public void verifyLoginMessage(String message) {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(MyAccountPageUI.TEXTO_CONFIRMACIÓN_USUARIO, isVisible())
                        .forNoMoreThan(15).seconds()
        );

        theActorInTheSpotlight().should(
                seeThat("El mensaje de pedidos en el dashboard",
                        Text.of(MyAccountPageUI.TEXTO_CONFIRMACIÓN_USUARIO),
                        containsString(message))
        );
    }
}