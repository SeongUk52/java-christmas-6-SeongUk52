package christmas.constants;

import java.time.LocalDate;
import java.util.function.Function;

public enum DiscountConstant {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", (date) -> {
        if (date <= 25) {
            return 900 + 100 * date;
        }
        return 0;
    });

    private final String name;
    private final Function<Integer, Integer> discountAmount;

    DiscountConstant(String name, Function<Integer, Integer> discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public int calculateDiscountAmount(LocalDate date) {
        return discountAmount.apply(date.getDayOfMonth());
    }
}
