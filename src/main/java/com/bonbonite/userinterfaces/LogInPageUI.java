package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LogInPageUI {




    public static final Target CAMPO_LOGIN_CEDULA = Target.the("campo cédula login")
            .located(By.id("username")); // WooCommerce usa 'username' para el login

    public static final Target CAMPO_LOGIN_PASSWORD = Target.the("campo contraseña login")
            .located(By.id("password")); // WooCommerce usa 'password' para el login

    public static final Target CHK_RECUERDAME = Target.the("checkbox Recuérdame")
            .located(By.id("rememberme"));

    public static final Target BTN_INICIAR_SESION = Target.the("botón Iniciar Sesión")
            .located(By.name("login"));

    public static final Target TEXT_INGRESA_A_TU_CUENTA = Target.the("texto de ingresa a tu cuenta")
            .locatedBy("//h2[contains(text(),'Ingresa a tu cuenta')]");
}
