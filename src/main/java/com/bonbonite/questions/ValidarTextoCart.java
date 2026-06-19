package com.bonbonite.questions;

import com.bonbonite.userinterfaces.PdpPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("el mensaje de confirmación del carrito")
public class ValidarTextoCart implements Question<String> {

    public static ValidarTextoCart elTextoAñadidoAlCarrito() {
        return new ValidarTextoCart();
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PdpPageUI.MSG_SE_AÑADIDO_A_TU_CARRITO, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(PdpPageUI.MSG_SE_AÑADIDO_A_TU_CARRITO).answeredBy(actor);
    }
}