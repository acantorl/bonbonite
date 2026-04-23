package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePageUI {



    public static final Target HEADER_MSG_BAR = Target.the("mensaje de barra de header")
            .located(By.xpath("//div[contains(@class, 'message_bar')]//p[contains(text(), 'Hecho a mano')]"));

    public static final Target BTN_RECHAZAR_COOKIES = Target.the("botón rechazar cookies")
            .located(By.id("cookiescript_reject"));

    public static final Target BTN_LUPA = Target.the("lupa de búsqueda")
            .located(By.id("search-btn"));

    public static final Target BTN_MI_CUENTA = Target.the("botón mi cuenta")
            .located(By.id("toggle-account-menu"));

    public static final Target BTN_CARRITO = Target.the("boton carrito")
            .located(By.cssSelector(".flex.gap-8 a[title='View your shopping cart']"));

    public static final Target BTN_IZQ_SLIDER = Target.the("boton izquierdo slider")
            .located(By.cssSelector(".home-slider-button-prev"));

    public static final Target BTN_DER_SLIDER = Target.the("boton derecho slider")
            .located(By.cssSelector(".home-slider-button-next"));

    public static final Target REGISTER_LINK = Target.the("enlace de registro")
            .located(By.cssSelector("#customer_login #show_register"));

    public static final Target CAMPO_NUMERO_CEDULA = Target.the("campo cédula")
            .located(By.cssSelector("#form-register #reg_username"));
}