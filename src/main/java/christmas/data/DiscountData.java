package christmas.data;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.DayOfWeek.SATURDAY;

import christmas.domain.Dishes;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;

public enum DiscountData {
    CHRISTMAS_D_DAY("크리스마스 디데이 할인", (date, dishes) -> {
        if (date.getDayOfMonth() <= 25) {
            return 900 + 100 * date.getDayOfMonth();
        }

        return 0;
    }),
    WEEKDAY("평일 할인", (date, dishes) -> {
        if (!isWeekEnd(date)) {
            return calculateDiscountOf("디저트", dishes, 2_023);
        }

        return 0;
    }),
    WEEKEND("주말 할인", (date, dishes) -> {
        if (isWeekEnd(date)) {
            return calculateDiscountOf("메인", dishes, 2_023);
        }

        return 0;
    }),
    SPECIAL_DISCOUNT("특별 할인", (date, dishes) -> {
        if (List.of(3, 10, 17, 24, 25, 31).contains(date.getDayOfMonth())) {
            return 1_000;
        }

        return 0;
    });

    private final String name;
    private final BiFunction<LocalDate, Dishes, Integer> discountAmount;

    DiscountData(String name, BiFunction<LocalDate, Dishes, Integer> discountAmount) {
        this.name = name;
        this.discountAmount = discountAmount;
    }

    private static boolean isWeekEnd(LocalDate date) {
        return List.of(FRIDAY, SATURDAY).contains(date.getDayOfWeek());
    }

    private static int calculateDiscountOf(String categori, Dishes dishes, int discountAmount) {
        return dishes.calculateDiscountOf(categori, discountAmount);
    }

    public int calculateDiscountAmount(LocalDate date, Dishes dishes) {
        return discountAmount.apply(date, dishes);
    }

    public int calculateDiscountAmount(LocalDate date) {
        return discountAmount.apply(date, null);
    }

    @Override
    public String toString() {
        return name;
    }
}
