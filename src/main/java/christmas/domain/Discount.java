package christmas.domain;

import static christmas.constants.SystemMessage.BENEFIT_FORMAT;

import christmas.data.DiscountData;
import java.time.LocalDate;

public class Discount {
    private final DiscountData discountType;
    private final int dicountAmount;

    private Discount(DiscountData discountType, int dicountAmount) {
        this.discountType = discountType;
        this.dicountAmount = dicountAmount;
    }

    public static Discount of(DiscountData discountType, LocalDate date, Dishes dishes) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date, dishes));
    }

    public static Discount of(DiscountData discountType, LocalDate date) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date));
    }

    public static Discount createEmpty() {
        return new Discount(null, 0);
    }

    public String toMessage() {
        if (dicountAmount == 0) {
            return null;
        }
        return String.format(BENEFIT_FORMAT.toString(), discountType.toString(), dicountAmount);
    }

    @Override
    public String toString() {
        return discountType.toString();
    }

    public int getDicountAmount() {
        return dicountAmount;
    }
}
