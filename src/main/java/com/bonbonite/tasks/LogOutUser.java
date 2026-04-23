package com.bonbonite.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.bonbonite.userinterfaces.MyAccountPageUI.BTN_LOGOUT;
import static com.bonbonite.userinterfaces.MyAccountPageUI.BTN_LOGO_USUARIO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogOutUser implements Task {


    public static LogOutUser asUser() {
        return instrumented(LogOutUser.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGO_USUARIO),
                Click.on(BTN_LOGOUT)
        );
    }
}
