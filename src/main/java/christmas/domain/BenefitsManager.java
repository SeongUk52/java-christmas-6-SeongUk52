package christmas.domain;

import christmas.data.DiscountData;
import christmas.data.FreeGiftData;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class BenefitsManager {
    private final List<Discount> discounts;
    private final List<Dish> freeGifts;

    private BenefitsManager(List<Discount> discounts, List<Dish> freeGifts) {
        this.discounts = discounts;
        this.freeGifts = freeGifts;
    }

    public static BenefitsManager of(LocalDate date, int regularPrice, List<Dish> dishes) {
        return new BenefitsManager(calculateDiscounts(date, dishes), createFreeGifts(regularPrice));
    }

    private static List<Discount> calculateDiscounts(LocalDate date, List<Dish> dishes) {
        return Arrays.stream(DiscountData.values())
                .map(i -> Discount.of(i, date, dishes))
                .toList();
    }

    private static List<Dish> createFreeGifts(int regularPrice) {
        return Arrays.stream(FreeGiftData.values())
                .map(i -> i.getFreeGift(regularPrice))
                .toList();
    }

    public int calculateTotalBenefits() {
        return 0;
        //TODO 2023-11-13 테스트 코드 작성 후 작성
    }
}
