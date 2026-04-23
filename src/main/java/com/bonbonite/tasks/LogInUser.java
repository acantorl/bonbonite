package com.bonbonite.tasks;

import com.bonbonite.interactions.Esperar;
import com.bonbonite.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bonbonite.userinterfaces.LogInPageUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static com.bonbonite.userinterfaces.HomePageUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LogInUser implements Task {

    private final String cedula;
    private final String password;

    public LogInUser(String cedula, String password) {
        this.cedula = cedula;
        this.password = password;
    }

    public static LogInUser conCredenciales(String cedula, String password) {
        return instrumented(LogInUser.class, cedula, password);
    }

    @Override
    @Step("{0} inicia sesión con cédula #cedula")
    public <T extends Actor> void performAs(T actor) {
        String username;
        actor.attemptsTo(
                Check.whether(HomePageUI.BTN_RECHAZAR_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePageUI.BTN_RECHAZAR_COOKIES)),
                Click.on(BTN_MI_CUENTA),
                Enter.theValue(cedula).into(CAMPO_LOGIN_CEDULA),
                Enter.theValue(password).into(CAMPO_LOGIN_PASSWORD),
                Esperar.por(1000),
                Click.on(CHK_RECUERDAME),
                Esperar.por(1000),
                WaitUntil.the(BTN_INICIAR_SESION, isVisible()),
                Click.on(BTN_INICIAR_SESION)
        );
    }
}