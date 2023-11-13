package christmas.domain;

import java.util.List;

public class BenefitsManager {
    private final List<Discount> discounts;
    private final Dish freeGift;

    private BenefitsManager(List<Discount> discounts, Dish freeGift) {
        this.discounts = discounts;
        this.freeGift = freeGift;
    }

    public int calculateTotalBenefits() {
        return 0;
        //TODO 2023-11-13 테스트 코드 작성 후 작성
    }
}
