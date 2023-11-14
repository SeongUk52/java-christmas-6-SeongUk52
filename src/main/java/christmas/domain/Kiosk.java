package christmas.domain;

import static christmas.constants.CautionCategory.EVENT_DISCOUNT_APPLIED;
import static christmas.constants.CautionCategory.EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION;
import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemString.KIOSK_SEPARATOR;

import christmas.data.EventCautionCondition;
import java.util.Arrays;
import java.util.List;

public class Kiosk {
    private final Dishes dishes;

    private Kiosk(List<Dish> dishes) {
        this.dishes = Dishes.from(dishes);
        if (isExceptionCondition()) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    public static Kiosk from(String menusAndAmounts) {
        return new Kiosk(createDishs(menusAndAmounts));
    }

    private static List<Dish> createDishs(String menusAndAmounts) {
        return Arrays.stream(menusAndAmounts.split(KIOSK_SEPARATOR.toString()))
                .map(Dish::from)
                .toList();
    }

    public boolean isApplyDiscount() {
        return Arrays.stream(EventCautionCondition.values())
                .filter(i -> i.isEqualCategory(EVENT_DISCOUNT_APPLIED))
                .anyMatch(i -> i.isCondition(dishes));
    }

    public boolean isExceptionCondition() {
        return Arrays.stream(EventCautionCondition.values())
                .filter(i -> i.isEqualCategory(EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION))
                .anyMatch(i -> i.isCondition(dishes));
    }
}
