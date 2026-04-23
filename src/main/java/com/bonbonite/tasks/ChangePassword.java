package com.bonbonite.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bonbonite.userinterfaces.MyAccountPageUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ChangePassword implements Task {

    private final String oldPassword;
    private final String newPassword;

    public ChangePassword(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public static ChangePassword de(String oldPassword, String newPassword) {
        return instrumented(ChangePassword.class, oldPassword, newPassword);
    }

    @Override
    @Step("{0} cambia su contraseña actual #oldPassword por la nueva #newPassword")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_OPCION_DATOS, isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(BTN_OPCION_DATOS),
                JavaScriptClick.on(BTN_OPCION_DATOS),
                WaitUntil.the(BTN_ACTUALIZAR_CONTRASENA, isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(BTN_ACTUALIZAR_CONTRASENA),
                Enter.theValue(oldPassword).into(CAMPO_CONTRASENA_ACTUAL),
                Enter.theValue(newPassword).into(CAMPO_NUEVA_CONTRASENA),
                Enter.theValue(newPassword).into(CAMPO_REPETIR_NUEVA_CONTRASENA),
                JavaScriptClick.on(BTN_GUARDAR_CONTRASENA)
        );
    }
}