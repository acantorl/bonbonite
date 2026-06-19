package com.bonbonite.tasks;

import com.bonbonite.userinterfaces.HomePageUI;
import com.bonbonite.userinterfaces.LogInPageUI;
import com.bonbonite.userinterfaces.MyAccountPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
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
        actor.attemptsTo(
                // 1. Sincronización inicial de la tienda
                WaitUntil.the(HomePageUI.BTN_MI_CUENTA, isVisible()).forNoMoreThan(15).seconds(),

                // 2. Control preventivo de cookies
                Check.whether(HomePageUI.BTN_RECHAZAR_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePageUI.BTN_RECHAZAR_COOKIES)),

                // MEJORA: Navegamos primero para validar con certeza el estado de la sesión
                WaitUntil.the(HomePageUI.BTN_MI_CUENTA, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(HomePageUI.BTN_MI_CUENTA),

                // 3. Limpieza del estado de sesión (Solo si se requiere)
                Check.whether(MyAccountPageUI.BTN_LOGOUT.resolveFor(actor).isVisible())
                        .andIfSo(
                                Click.on(MyAccountPageUI.BTN_LOGOUT),
                                WaitUntil.the(HomePageUI.BTN_MI_CUENTA, isVisible()),
                                Click.on(HomePageUI.BTN_MI_CUENTA)
                        ),

                // 4. Ingreso de Datos seguros
                WaitUntil.the(LogInPageUI.CAMPO_LOGIN_CEDULA, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(cedula).into(LogInPageUI.CAMPO_LOGIN_CEDULA),
                Enter.theValue(password).into(LogInPageUI.CAMPO_LOGIN_PASSWORD),

                // 5. Envío del formulario
                WaitUntil.the(LogInPageUI.CHK_RECUERDAME, isClickable()),
                Click.on(LogInPageUI.CHK_RECUERDAME),

                WaitUntil.the(LogInPageUI.BTN_INICIAR_SESION, isClickable()),
                Click.on(LogInPageUI.BTN_INICIAR_SESION)
        );
    }
}