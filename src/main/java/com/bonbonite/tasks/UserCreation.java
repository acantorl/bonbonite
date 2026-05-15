package com.bonbonite.tasks;

import com.bonbonite.interactions.Esperar;
import com.bonbonite.userinterfaces.HomePageUI;
import com.bonbonite.userinterfaces.LogInPageUI;
import com.bonbonite.userinterfaces.RegisterPageUI;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static com.bonbonite.userinterfaces.LogInPageUI.BOTON_REGISTRARME;
import static com.bonbonite.userinterfaces.LogInPageUI.BOTON_REGISTRARME;
import static com.bonbonite.userinterfaces.RegisterPageUI.BOTON_REGISTRARME_FINAL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class UserCreation implements Task {

    private static final String[] NOMBRES = {"Adrian", "Carlos", "Juan", "Diego", "Luis", "Marta", "Elena", "Sofia", "Pablo", "Lucia"};
    private static final String[] APELLIDOS = {"Cantor", "Perez", "Rodriguez", "Lopez", "Garcia", "Gomez", "Sanchez", "Diaz", "Torres", "Ruiz"};

    public static UserCreation withRandomData() {
        return instrumented(UserCreation.class);
    }

    @Override
    @Step("{0} realiza el registro de un nuevo usuario con datos aleatorios")
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();
        String nombre = NOMBRES[random.nextInt(NOMBRES.length)];
        String apellido = APELLIDOS[random.nextInt(APELLIDOS.length)];
        String email = nombre.toLowerCase() + "." + apellido.toLowerCase() + RandomStringUtils.randomNumeric(3) + "@yopmail.com";
        String cedula = "1" + RandomStringUtils.randomNumeric(9);
        String password = "Pass" + RandomStringUtils.randomNumeric(4) + "*";

        actor.attemptsTo(
                Check.whether(HomePageUI.BTN_RECHAZAR_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePageUI.BTN_RECHAZAR_COOKIES)),

                Click.on(HomePageUI.BTN_MI_CUENTA),

                WaitUntil.the(BOTON_REGISTRARME, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTON_REGISTRARME),

                Enter.theValue(cedula).into(RegisterPageUI.CAMPO_CEDULA),
                Enter.theValue(nombre).into(RegisterPageUI.CAMPO_NOMBRES),
                Enter.theValue(apellido).into(RegisterPageUI.CAMPO_APELLIDOS),
                Enter.theValue(email).into(RegisterPageUI.CAMPO_EMAIL),
                Enter.theValue(password).into(RegisterPageUI.CAMPO_CONTRASEÑA),
                Enter.theValue(password).into(RegisterPageUI.CAMPO_COMFIRMAR_CONTRASEÑA),

                // Reemplazamos esperas fijas por esperas de estado
                WaitUntil.the(RegisterPageUI.CHECK_INFO_, isClickable()),
                Click.on(RegisterPageUI.CHECK_INFO_),

                WaitUntil.the(RegisterPageUI.CHECK_AUTORIZACIÓN, isClickable()),
                Click.on(RegisterPageUI.CHECK_AUTORIZACIÓN),

                WaitUntil.the(BOTON_REGISTRARME_FINAL, isClickable()),
                Click.on(BOTON_REGISTRARME_FINAL)
        );
    }
}