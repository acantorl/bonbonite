package com.bonbonite.questions;

import com.bonbonite.userinterfaces.PlpPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarFiltros implements Question<String> {

    public static ValidarFiltros elTextoFiltros() {
        return new ValidarFiltros();
    }

    @Override
    public String answeredBy(Actor actor) {
        // MEJORA: Espera explícita para asegurar que el listado de productos terminó de cargar
        actor.attemptsTo(
                WaitUntil.the(PlpPageUI.LABEL_FILTROS, isVisible()).forNoMoreThan(10).seconds()
        );
        return Text.of(PlpPageUI.LABEL_FILTROS).answeredBy(actor);
    }
}