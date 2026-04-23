package com.bonbonite.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PlpPageUI {

    public static final Target LABEL_FILTROS = Target.the("texto de filtros")
            .located(By.id("filters-text"));

    public static final Target PRODUCT_GRID = Target.the("grilla de productos")
            .locatedBy("//div[contains(@class, 'grid-cols-2')]/div[contains(@class, 'group')]");

    public static final Target FIRST_CARD_TENNIS = Target.the("primera card tenis")
            .locatedBy("//div[contains(@class, 'grid-cols-2')]/div[contains(@class, 'group')][1]");
}