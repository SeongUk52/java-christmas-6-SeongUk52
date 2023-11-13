package christmas.constants;

import java.time.LocalDate;
import java.util.function.Function;

public enum DiscountConstant {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", (date) -> {
        if (date.getDayOfMonth() <= 25) {
            return 900 + 100 * date.getDayOfMonth();
        }
        return 0;
    });
    /*
    WEEKDAY("평일 할인", (date) -> {
        if (date.getDayOfWeek())
    }),
    WEEKEND(),
    SPECIAL_DISCOUNT();


     */
    //TODO 2023-11-13 19:33
    private final String name;
    private final Function<LocalDate, Integer> discountAmount;

    DiscountConstant(String name, Function<LocalDate, Integer> discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    public int calculateDiscountAmount(LocalDate date) {
        return discountAmount.apply(date);
    }
}
