package com.bonbonite.stepdefinitions;

import com.bonbonite.questions.ValidarRegistro;
import com.bonbonite.tasks.UserCreation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class CreationUserStepDefinitions {

    @When("they register a user account")
    public void registerUserAccount() {
        theActorInTheSpotlight().attemptsTo(
                UserCreation.withRandomData()
        );
    }

    @Then("the orders section must indicate {string}")
    public void verifyRegistrationMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje de confirmación en el dashboard de la cuenta",
                        ValidarRegistro.elMensajeDeBienvenida(),
                        containsString(message))
        );
    }
}