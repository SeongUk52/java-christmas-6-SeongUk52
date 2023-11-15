package christmas.domain;

import static christmas.constants.SystemConstant.BASIC_INIT_NUMBER;
import static christmas.constants.SystemMessage.BENEFIT_FORMAT;

import christmas.data.DiscountData;
import java.time.LocalDate;

public class Discount {
    private final DiscountData discountType;
    private final int discountAmount;

    private Discount(DiscountData discountType, int discountAmount) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
    }

    public static Discount of(DiscountData discountType, LocalDate date, Dishes dishes) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date, dishes));
    }

    public static Discount of(DiscountData discountType, LocalDate date) {
        return new Discount(discountType, discountType.calculateDiscountAmount(date));
    }

    public String toMessage() {
        if (discountAmount == BASIC_INIT_NUMBER.getValue()) {
            return null;
        }
        
        return String.format(BENEFIT_FORMAT.toString(), discountType.toString(), discountAmount);
    }

    public boolean isPresent() {
        return discountAmount > BASIC_INIT_NUMBER.getValue();
    }

    @Override
    public String toString() {
        return discountType.toString();
    }

    public int getDiscountAmount() {
        return discountAmount;
    }
}
