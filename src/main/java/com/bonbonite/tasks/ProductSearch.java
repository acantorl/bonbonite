package com.bonbonite.tasks;

import com.bonbonite.userinterfaces.HomePageUI;
import com.bonbonite.userinterfaces.SearchPageUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProductSearch implements Task {
    private final String product;

    public ProductSearch(String product) {
        this.product = product;
    }

    public static ProductSearch conNombre(String product) {
        return instrumented(ProductSearch.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // MEJORA: Esperamos brevemente que la página se estabilice antes de revisar las cookies
                Check.whether(HomePageUI.BTN_RECHAZAR_COOKIES.resolveFor(actor).isVisible())
                        .andIfSo(Click.on(HomePageUI.BTN_RECHAZAR_COOKIES)),

                // MEJORA: Esperar que la lupa sea clickeable por si el DOM sigue cargando scripts
                WaitUntil.the(HomePageUI.BTN_LUPA, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(HomePageUI.BTN_LUPA),

                Enter.theValue(product).into(SearchPageUI.INPUT_BUSQUEDA),
                Click.on(SearchPageUI.BTN_BUSCAR)
        );
    }
}