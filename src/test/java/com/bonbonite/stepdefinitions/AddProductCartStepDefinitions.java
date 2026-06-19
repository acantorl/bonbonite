package com.bonbonite.stepdefinitions;

import com.bonbonite.questions.ValidarTextoCart;
import com.bonbonite.tasks.AddProductToCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
        // Limpiamos los puntos suspensivos que vienen desde el feature
        String mensajeClave = textoEsperado.replace(".", "").trim();

        // Usamos la Question que ya maneja internamente el WaitUntil de manera segura
        theActorInTheSpotlight().should(
                seeThat("Verificar el mensaje de éxito en el carrito",
                        ValidarTextoCart.elTextoAñadidoAlCarrito(),
                        containsStringIgnoringCase(mensajeClave))
        );
    }
}