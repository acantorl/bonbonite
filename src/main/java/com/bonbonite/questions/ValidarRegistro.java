package com.bonbonite.questions;

import com.bonbonite.userinterfaces.MyAccountPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarRegistro implements Question<String> {

    public static ValidarRegistro elMensajeDeBienvenida() {
        return new ValidarRegistro();
    }

    @Override
    public String answeredBy(Actor actor) {
        // MEJORA: Espera explícita para dar tiempo a la redirección post-registro
        actor.attemptsTo(
                WaitUntil.the(MyAccountPageUI.TEXTO_CONFIRMACIÓN_USUARIO, isVisible()).forNoMoreThan(15).seconds()
        );
        return Text.of(MyAccountPageUI.TEXTO_CONFIRMACIÓN_USUARIO).answeredBy(actor);
    }
}