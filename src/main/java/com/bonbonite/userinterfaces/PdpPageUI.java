package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PdpPageUI {

    public static final Target SIZE_SHOE = Target.the("talla de zapato")
    .located(By.xpath("//div[contains(@class, 'variation-buttons')]//button[@data-value='40']"));

    public static final Target BTN_AÑADIR_AL_CARRITO = Target.the("botón de añadir al carrito")
            .located(By.xpath("//button[@name='add-to-cart' or contains(@class, 'single_add_to_cart_button')]"));

    public static final Target MSG_SE_AÑADIDO_A_TU_CARRITO = Target.the("mensaje de confirmación del carrito")
            .locatedBy("//div[@role='alert' and contains(translate(., 'ABCDEFGHIJKLMNÑOPQRSTUVWXYZ', 'abcdefghijklmnñopqrstuvwxyz'), 'se ha añadido a tu carrito')]");

    public static final Target BTN_AÑADIR_AL_CARRITO2 = Target.the("botón de añadir al carrito")
            .located(By.cssSelector("button.single_add_to_cart_button:not(.hidden)"));
}
