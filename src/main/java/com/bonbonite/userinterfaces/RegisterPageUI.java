package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPageUI {



    public static final Target CAMPO_CEDULA = Target.the("campo de cédula")
            .located(By.cssSelector("#form-register #reg_username"));

    public static final Target CAMPO_NOMBRES = Target.the("campo de nombres")
            .located(By.cssSelector("#form-register #first_name"));

    public static final Target CAMPO_APELLIDOS = Target.the("campo de apellidos ")
            .located(By.cssSelector("#form-register #last_name"));

    public static final Target CAMPO_EMAIL = Target.the("campo de email")
            .located(By.cssSelector("#form-register #reg_email"));

    public static final Target CAMPO_CONTRASEÑA = Target.the("campo de contraseña ")
            .located(By.cssSelector("#form-register #reg_password"));

    public static final Target CAMPO_COMFIRMAR_CONTRASEÑA = Target.the("campo de confirmar contraseña ")
            .located(By.cssSelector("#form-register #reg_password2"));

    public static final Target CHECK_INFO_ = Target.the("check de información")
            .located(By.cssSelector("#form-register #newsletter_authorization"));

    public static final Target CHECK_AUTORIZACIÓN = Target.the("check de autorización ")
            .located(By.cssSelector("#form-register #privacy_policy_reg"));


    public static final Target BOTON_REGISTRARME_FINAL = Target.the("botón final de registrarme")
            .located(By.name("register"));




}
