package com.bonbonite.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bonbonite.userinterfaces.MyAccountPageUI.BTN_LOGOUT;
import static com.bonbonite.userinterfaces.MyAccountPageUI.BTN_LOGO_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LogOutUser implements Task {

    public static LogOutUser asUser() {
        return instrumented(LogOutUser.class);
    }

    @Override
    @Step("{0} cierra la sesión actual")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Esperamos a que el logo de usuario sea clickeable tras el login
                WaitUntil.the(BTN_LOGO_USUARIO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_LOGO_USUARIO),

                // Aseguramos que el botón de logout aparezca en el menú
                WaitUntil.the(BTN_LOGOUT, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(BTN_LOGOUT)
        );
    }
}