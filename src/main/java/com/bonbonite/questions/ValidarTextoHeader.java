package com.bonbonite.questions;

import com.bonbonite.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarTextoHeader implements Question<String> {

    public static ValidarTextoHeader elTextoHeader() {
        return new ValidarTextoHeader();
    }

    @Override
    public String answeredBy(Actor actor) {
        // Captura el texto de la barra superior (Header Bar)
        return Text.of(HomePageUI.HEADER_MSG_BAR).answeredBy(actor);
    }
}