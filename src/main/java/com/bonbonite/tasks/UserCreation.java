package com.bonbonite.tasks;

import com.bonbonite.interactions.Esperar;
import com.bonbonite.userinterfaces.HomePageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

import static com.bonbonite.userinterfaces.RegisterPageUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static com.bonbonite.userinterfaces.HomePageUI.*;

public class UserCreation implements Task {

    private static final String[] NOMBRES_ES = {"adrian", "carlos", "juan", "diego", "luis", "marta", "elena", "sofia", "pablo", "lucia"};
    private static final String[] APELLIDOS_ES = {"cantor", "perez", "rodriguez", "lopez", "garcia", "gomez", "sanchez", "diaz", "torres", "ruiz"};

    @Override
    @Step("{0} realiza el registro de un nuevo usuario con datos aleatorios")
    public <T extends Actor> void performAs(T actor) {

        Random random = new Random();

        String nombre = NOMBRES_ES[random.nextInt(NOMBRES_ES.length)];
        String apellido = APELLIDOS_ES[random.nextInt(APELLIDOS_ES.length)];


        String email = nombre + "." + apellido + RandomStringUtils.randomNumeric(3) + "@hotmail.com";

        String cedula = "1" + RandomStringUtils.randomNumeric(9);

        String password = RandomStringUtils.randomNumeric(8) + "A" + "b" + "*";

        actor.attemptsTo(
                Check.whether(HomePageUI.BTN_RECHAZAR_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePageUI.BTN_RECHAZAR_COOKIES)),
                Click.on(BTN_MI_CUENTA),
                WaitUntil.the(REGISTER_LINK, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(REGISTER_LINK),
                Enter.theValue(cedula).into(CAMPO_NUMERO_CEDULA),
                Enter.theValue(nombre).into(CAMPO_NOMBRES),
                Enter.theValue(apellido).into(CAMPO_APELLIDOS),
                Enter.theValue(email).into(CAMPO_EMAIL),
                Enter.theValue(password).into(CAMPO_CONTRASEÑA),
                Enter.theValue(password).into(CAMPO_COMFIRMAR_CONTRASEÑA),
                WaitUntil.the(CHECK_INFO_, isVisible()),
                Esperar.por(1000),
                Click.on(CHECK_INFO_),
                WaitUntil.the(CHECK_AUTORIZACIÓN, isVisible()),
                Esperar.por(1000),
                Click.on(CHECK_AUTORIZACIÓN),
                Esperar.por(1000),
                Click.on(BOTON_REGISTRARME)
        );
    }
    public static UserCreation withRandomData() {
        return instrumented(UserCreation.class);
    }
}