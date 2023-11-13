package christmas.domain;

import static christmas.constants.SystemMessage.BENEFIT_FORMAT;
import static christmas.constants.SystemMessage.FREE_GIFT;

import christmas.data.DiscountData;
import christmas.data.FreeGiftData;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BenefitsManager {
    private final List<Discount> discounts;
    private final List<Dish> freeGifts;
    //TODO 2023-11-14 03:05 불변 리스트로 전환

    private BenefitsManager(List<Discount> discounts, List<Dish> freeGifts) {
        this.discounts = discounts;
        this.freeGifts = freeGifts;
    }

    public static BenefitsManager of(LocalDate date, Dishes dishes) {
        return new BenefitsManager(calculateDiscounts(date, dishes), createFreeGifts(dishes.calculateRegularPrice()));
    }

    private static List<Discount> calculateDiscounts(LocalDate date, Dishes dishes) {
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
        return calculateTotlaDiscounts() + calculateTotalFreeGift();
    }

    private int calculateTotlaDiscounts() {
        return discounts.stream()
                .map(Discount::getDicountAmount)
                .reduce(0, Integer::sum);
    }

    private int calculateTotalFreeGift() {
        return freeGifts.stream()
                .map(Dish::calculatePrice)
                .reduce(0, Integer::sum);
    }

    public List<String> freeGiftToString() {
        return freeGifts.stream()
                .map(Dish::toMessage)
                .toList();
    }

    public List<String> toStrings() {
        return Stream.concat(discounts.stream().map(Discount::toMessage), totalFreeGiftToString())
                .toList();
    }

    private Stream<String> totalFreeGiftToString() {
        return String.format(BENEFIT_FORMAT.toString(), FREE_GIFT, calculateTotalFreeGift()).lines();
    }
}
