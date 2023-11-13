package christmas.domain;

import static christmas.constants.SystemString.KIOSK_SEPARATOR;

import java.util.Arrays;
import java.util.List;

public class Kiosk {
    private final List<Dish> dishes;

    private Kiosk(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public static Kiosk from(String menusAndAmounts) {
        return new Kiosk(createDishs(menusAndAmounts));
    }

    private static List<Dish> createDishs(String menusAndAmounts) {
        return Arrays.stream(menusAndAmounts.split(KIOSK_SEPARATOR.toString()))
                .map(Dish::from)
                .toList();
    }
}
