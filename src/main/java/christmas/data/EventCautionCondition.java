package christmas.data;

import static christmas.constants.CautionCategory.EVENT_DISCOUNT_APPLIED;
import static christmas.constants.CautionCategory.EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION;

import christmas.constants.CautionCategory;
import christmas.domain.Dish;
import christmas.domain.Dishes;
import java.util.function.Function;

public enum EventCautionCondition {
    BIGGER_THAN_10_000((dishes) -> dishes.calculateRegularPrice() >= 10_000, EVENT_DISCOUNT_APPLIED),
    ONLY_BUY_DRINK((Dishes) -> Dishes.stream()
            .allMatch(i -> i.is("음료")), EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION),
    MORE_THAN_TWENTY_ORDER((Dishes) -> Dishes.stream()
            .map(Dish::getAmount)
            .reduce(0, Integer::sum) > 20, EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION);

    private final Function<Dishes, Boolean> condition;
    private final CautionCategory category;

    EventCautionCondition(Function<Dishes, Boolean> condition, CautionCategory category) {
        this.condition = condition;
        this.category = category;
    }

    public boolean isCondition(Dishes dishes) {
        return condition.apply(dishes);
    }

    public CautionCategory getCategory() {
        return this.category;
    }
}
