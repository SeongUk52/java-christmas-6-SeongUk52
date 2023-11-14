package christmas.domain;

import static christmas.constants.SystemMessage.BENEFIT_FORMAT;
import static christmas.constants.SystemMessage.FREE_GIFT;

import christmas.data.DiscountData;
import christmas.data.FreeGiftData;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class BenefitsManager {
    private final List<Discount> discounts;
    private final Dishes freeGifts;
    //TODO 2023-11-14 03:05 불변 리스트로 전환

    private BenefitsManager(List<Discount> discounts, Dishes freeGifts) {
        this.discounts = discounts;
        this.freeGifts = freeGifts;
    }

    public static BenefitsManager of(LocalDate date, Dishes dishes) {
        return new BenefitsManager(calculateDiscounts(date, dishes), createFreeGifts(dishes.calculateRegularPrice()));
    }

    public static BenefitsManager createNoBenefits() {
        return new BenefitsManager(List.of(), Dishes.createEmpty());
    }

    private static List<Discount> calculateDiscounts(LocalDate date, Dishes dishes) {
        return Arrays.stream(DiscountData.values())
                .map(i -> Discount.of(i, date, dishes))
                .filter(Discount::isPresent)
                .toList();
    }

    private static Dishes createFreeGifts(int regularPrice) {
        return Dishes.from(Arrays
                .stream(FreeGiftData.values())
                .map(i -> i.getFreeGift(regularPrice))
                .filter(Objects::nonNull)
                .toList());
    }

    public int calculateTotalBenefits() {
        return calculateTotalDiscounts() + calculateTotalFreeGift();
    }

    public int calculateTotalDiscounts() {
        return discounts.stream()
                .map(Discount::getDicountAmount)
                .reduce(0, Integer::sum);
    }

    private int calculateTotalFreeGift() {
        return freeGifts.stream()
                .map(Dish::calculatePrice)
                .reduce(0, Integer::sum);
    }

    public Optional<List<String>> freeGiftToStringListOptional() {
        if (freeGifts.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(freeGifts.stream()
                .map(Dish::toMessage)
                .toList());
    }

    public Optional<List<String>> toStrings() {
        if (totalFreeGiftToString().isPresent()) {
            return Optional.of(Stream.concat(discounts.stream().map(Discount::toMessage),
                            totalFreeGiftToString().orElseThrow())
                    .toList());
        }
        return Optional.empty();
    }

    private Optional<Stream<String>> totalFreeGiftToString() {
        if (calculateTotalFreeGift() <= 0) {
            return Optional.empty();
        }
        return Optional.of(String.format(BENEFIT_FORMAT.toString(), FREE_GIFT, calculateTotalFreeGift()).lines());
    }
}
