package com.bonbonite.stepdefinitions;

import com.bonbonite.questions.ValidarTextoHeader;
import com.bonbonite.tasks.LogOutUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class LogOutUserStepDefinitions {

    @When("he logs out")
    public void heLogsOut() {
        theActorInTheSpotlight().attemptsTo(
                LogOutUser.asUser()
        );
    }

    @Then("he should see a header message related to {string}")
    public void heShouldSeeAHeaderMessageRelatedTo(String expectedText) {
        theActorInTheSpotlight().should(
                seeThat("El texto visible en el encabezado",
                        ValidarTextoHeader.elTextoHeader(),
                        equalToIgnoringCase(expectedText)) // Cambiado aquí
        );
    }
}