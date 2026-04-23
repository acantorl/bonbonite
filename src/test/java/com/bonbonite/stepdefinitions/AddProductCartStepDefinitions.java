package com.bonbonite.stepdefinitions;

import com.bonbonite.questions.ValidarTextoCart;
import com.bonbonite.tasks.AddProductToCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsStringIgnoringCase;

public class AddProductCartStepDefinitions {



    @When("adds the product to the cart")
    public void addsTheProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(
                AddProductToCart.now()
        );


    }


    @Then("the PLP page should display the message {string}")
    public void thePLPPageShouldDisplayTheMessage(String textoEsperado) {
        String mensajeClave = textoEsperado.replace(".", "").trim();

        OnStage.theActorInTheSpotlight().should(
                seeThat("Verificar el mensaje en el carrito",
                        ValidarTextoCart.elTextoAñadidoAlCarrito(),
                        containsStringIgnoringCase(mensajeClave))
        );
    }



}
