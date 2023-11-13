package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER;
import static christmas.constants.SystemConstant.BASE_PRICE;
import static christmas.constants.SystemString.KIOSK_SEPARATOR;

import java.util.Arrays;
import java.util.List;

public class Kiosk {
    private final List<Dish> dishes;

    private Kiosk(List<Dish> dishes) {
        validateDistinct(dishes);
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

    private void validateDistinct(List<Dish> dishes) {
        if (!isDistinct(dishes)) {
            throw new IllegalArgumentException(ORDER.toString());
        }
    }

    private boolean isDistinct(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::getMenu)
                .distinct()
                .count() == dishes.size();
        //TODO 2023-11-13 21:47 Dishes 클래스 생성 후 거기서 계산하면 더 좋을듯
    }

    public int calculateTotalPriceBeforeBenefits() {
        return dishes.stream()
                .map(Dish::calculatePrice)
                .reduce(BASE_PRICE.getValue(), Integer::sum);
    }
}
