package com.bonbonite.tasks;

import net.serenitybdd.annotations.Step; // Asegura la documentación en el reporte
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static com.bonbonite.userinterfaces.PdpPageUI.BTN_AÑADIR_AL_CARRITO;
import static com.bonbonite.userinterfaces.PdpPageUI.SIZE_SHOE;
import static com.bonbonite.userinterfaces.PlpPageUI.FIRST_CARD_TENNIS;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AddProductToCart implements Task {

    public static AddProductToCart now() {
        return instrumented(AddProductToCart.class);
    }

    @Override
    @Step("{0} selecciona la talla del calzado y añade el producto al carrito")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperar e ingresar al producto desde la PLP
                WaitUntil.the(FIRST_CARD_TENNIS, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(FIRST_CARD_TENNIS),

                // Selección de la talla (PDP)
                WaitUntil.the(SIZE_SHOE, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(SIZE_SHOE),
                Hit.the(Keys.ESCAPE).into(SIZE_SHOE), // Libera el foco del dropdown

                // Esperar a que el botón de añadir sea interactuable de forma real
                WaitUntil.the(BTN_AÑADIR_AL_CARRITO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_AÑADIR_AL_CARRITO) // Clic nativo para simular el comportamiento real del usuario
        );
    }
}