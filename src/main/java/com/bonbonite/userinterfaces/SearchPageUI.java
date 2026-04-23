package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchPageUI {
    public static final Target INPUT_BUSQUEDA = Target.the("campo de texto búsqueda")
            .located(By.id("s"));
    public static final Target BTN_BUSCAR = Target.the("botón buscar")
            .located(By.id("searchsubmit"));

    public static final Target CERRAR_BUSQUEDA = Target.the("botón de cerrar búsqueda")
            .located(By.id("close-search"));

    public static final Target BTN_WHATSAPP = Target.the("botón de whatsapp")
            .located(By.id("whats"));

}