package com.bonbonite.questions;

import com.bonbonite.userinterfaces.MyAccountPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarLogin implements Question<String> {

    public static ValidarLogin elMensajeDeDashboard() {
        return new ValidarLogin();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(MyAccountPageUI.TEXTO_CONFIRMACIÓN_USUARIO).answeredBy(actor);
    }
}