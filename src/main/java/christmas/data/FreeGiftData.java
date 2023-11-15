package christmas.data;

import christmas.domain.Dish;
import java.util.function.Function;

public enum FreeGiftData {
    CHRISTMAS_CHAMPAGNE((regularPrice) -> {
        if (regularPrice >= 120_000) {
            return Dish.from("샴페인-1");
        }
        return null;
    });

    private final Function<Integer, Dish> condition;

    FreeGiftData(Function<Integer, Dish> condition) {
        this.condition = condition;
    }

    public Dish applyFreeGiftFrom(int regularPrice) {
        return condition.apply(regularPrice);
    }
}
