package com.bonbonite.stepdefinitions;

import com.bonbonite.tasks.ProductSearch;
import com.bonbonite.questions.ValidarFiltros;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;


public class ProductSearchStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that the user navigates to the online store")
    public void navigateToStore() {
        OnStage.theActorCalled("Adrián").attemptsTo(Open.url("https://www.bon-bonite.com/"));
    }

    @When("the user search for the product {string}")
    public void searchForProduct(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(ProductSearch.conNombre(product));
    }

    @Then("the user should see results related to {string}")
    public void verifyResults(String textoEsperado) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ValidarFiltros.elTextoFiltros(), equalToIgnoringCase(textoEsperado))
        );
    }
}