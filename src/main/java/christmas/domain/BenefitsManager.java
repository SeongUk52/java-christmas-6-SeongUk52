package christmas.domain;

import christmas.utils.LocalDateFactory;
import java.time.LocalDate;

public class BenefitsManager {
    private final LocalDate date;
    private final int totalPriceBeforeBenfits;

    private BenefitsManager(LocalDate date, int totalPriceBeforeBenfits) {
        this.date = date;
        this.totalPriceBeforeBenfits = totalPriceBeforeBenfits;
    }

    public BenefitsManager of(String date, int totalPriceBeforeBenfits) {
        return new BenefitsManager(LocalDateFactory.createLocalDateFrom(date), totalPriceBeforeBenfits);
    }

    public int calculateTotalBenefits() {
        return 0;
        //TODO 2023-11-13 테스트 코드 작성 후 작성
    }
}
