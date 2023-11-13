package christmas.domain;

import christmas.data.DiscountData;
import java.time.LocalDate;
import java.util.List;

public class Discount {
    private final DiscountData discountType;
    private final int dicountAmount;

    private Discount(DiscountData discountType, int dicountAmount) {
        this.discountType = discountType;
        this.dicountAmount = dicountAmount;
    }

    public static Discount of(DiscountData discountType, LocalDate date, List<Dish> dishes) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date, dishes));
    }

    public static Discount of(DiscountData discountType, LocalDate date) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date));
    }

    @Override
    public String toString() {
        return discountType.toString();
    }

    public int getDicountAmount() {
        return dicountAmount;
    }
}
