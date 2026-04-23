package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAccountPageUI {

    public static final Target TEXTO_CONFIRMACIÓN_USUARIO = Target.the("mensaje de confirmación de pedidos")
            .located(By.cssSelector(".woocommerce-MyAccount-content h4, h4.text-4xl"));

    public static final Target BTN_LOGO_USUARIO = Target.the("botón de logo de usuario")
            .located(By.id("user-icon-wrap"));

    public static final Target BTN_LOGOUT = Target.the("botón de cierre de sesión")
            .located(By.cssSelector("#header-account-menu a[href*='logout']"));

    public static final Target BTN_OPCION_DATOS = Target.the("opción Datos del menú")
            .locatedBy("//nav[@aria-label='Páginas de cuenta']//a[contains(text(),'Datos')]");

    public static final Target BTN_ACTUALIZAR_CONTRASENA = Target.the("botón Actualizar Contraseña")
            .located(By.cssSelector("button.update-password-btn"));

    public static final Target CAMPO_CONTRASENA_ACTUAL = Target.the("campo de contraseña actual")
            .located(By.id("current_password"));

    public static final Target CAMPO_NUEVA_CONTRASENA = Target.the("campo de nueva contraseña")
            .located(By.id("new_password"));

    public static final Target CAMPO_REPETIR_NUEVA_CONTRASENA = Target.the("campo de repetir nueva contraseña")
            .located(By.id("confirm_password"));

    public static final Target BTN_GUARDAR_CONTRASENA = Target.the("botón de guardar contraseña")
            .located(By.cssSelector("button.save-password-btn"));
}
