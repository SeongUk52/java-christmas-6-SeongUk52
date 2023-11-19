package christmas.domain;

import static christmas.constants.SystemConstant.BASIC_INIT_NUMBER;
import static christmas.constants.SystemMessage.BENEFIT_FORMAT;
import static christmas.constants.SystemMessage.FREE_GIFT;

import christmas.data.DiscountData;
import christmas.data.FreeGiftData;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class BenefitsManager {
    private final List<Discount> discounts;
    private final Dishes freeGifts;

    private BenefitsManager(List<Discount> discounts, Dishes freeGifts) {
        this.discounts = Collections.unmodifiableList(discounts);
        this.freeGifts = freeGifts;
    }

    public static BenefitsManager of(LocalDate date, Dishes dishes) {
        return new BenefitsManager(calculateDiscounts(date, dishes), createFreeGifts(dishes.calculatePrice()));
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
        return Dishes.from(Arrays.stream(FreeGiftData.values())
                .map(i -> i.applyFreeGiftFrom(regularPrice))
                .filter(Objects::nonNull)
                .toList());
    }

    public int calculateTotalBenefits() {
        return calculateTotalDiscounts() + calculateTotalFreeGift();
    }

    public int calculateTotalDiscounts() {
        return discounts.stream()
                .map(Discount::getDiscountAmount)
                .reduce(BASIC_INIT_NUMBER.getValue(), Integer::sum);
    }

    private int calculateTotalFreeGift() {
        return freeGifts.calculatePrice();
    }

    public Optional<List<String>> freeGiftToOptionalStringList() {
        if (freeGifts.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(freeGifts.toMessageList());
    }

    public Optional<List<String>> toOptionalStringList() {
        if (totalFreeGiftToOptionalStringStream().isPresent()) {
            return Optional.of(Stream.concat(discounts.stream().map(Discount::toMessage),
                    totalFreeGiftToOptionalStringStream().get()).toList());
        }

        return Optional.empty();
    }

    private Optional<Stream<String>> totalFreeGiftToOptionalStringStream() {
        if (calculateTotalFreeGift() <= BASIC_INIT_NUMBER.getValue()) {
            return Optional.empty();
        }

        return Optional.of(String.format(BENEFIT_FORMAT.toString(), FREE_GIFT, calculateTotalFreeGift()).lines());
    }
}
