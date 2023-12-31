package christmas.domain;

import static christmas.constants.CautionCategory.EVENT_DISCOUNT_APPLIED;
import static christmas.constants.CautionCategory.EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION;
import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemString.KIOSK_SEPARATOR;

import christmas.constants.CautionCategory;
import christmas.data.EventCautionCondition;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Kiosk {
    private final Dishes dishes;

    private Kiosk(List<Dish> dishes) {
        this.dishes = Dishes.from(dishes);
        if (isExceptionCondition()) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    public static Kiosk from(String menusAndAmounts) {
        return new Kiosk(createDishes(menusAndAmounts));
    }

    private static List<Dish> createDishes(String menusAndAmounts) {
        return Arrays.stream(menusAndAmounts.split(KIOSK_SEPARATOR.toString()))
                .map(Dish::from)
                .toList();
    }

    public boolean isApplyDiscount() {
        return isMatchCondition(EVENT_DISCOUNT_APPLIED);
    }

    public boolean isExceptionCondition() {
        return isMatchCondition(EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION);
    }

    private boolean isMatchCondition(CautionCategory category) {
        return Arrays.stream((EventCautionCondition.values()))
                .filter(i -> i.isEqualCategory(category))
                .anyMatch(i -> i.isCondition(dishes));
    }

    public Optional<List<String>> toOptionalStringList() {
        return Optional.of(dishes.toMessageList());
    }

    public int calculateRegularPrice() {
        return dishes.calculatePrice();
    }

    public Dishes toDishes() {
        return dishes;
    }
}
