package christmas.domain;

import christmas.constants.Menu;

public class Dish {
    private final Menu menu;
    private final int amount;

    private Dish(Menu menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

}
