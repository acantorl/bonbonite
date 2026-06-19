package com.bonbonite.stepdefinitions;

import com.bonbonite.questions.ValidarLogin;
import com.bonbonite.tasks.LogInUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

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
        // MEJORA: El Step no interactúa, delega el control de sincronización directamente a la Question
        theActorInTheSpotlight().should(
                seeThat("El mensaje de pedidos en el dashboard",
                        ValidarLogin.elMensajeDeDashboard(),
                        containsString(message))
        );
    }
}