package christmas.domain;

import static christmas.data.DiscountData.SPECIAL_DISCOUNT;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.utils.LocalDateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    @DisplayName("문자열 변환 기능 테스트")
    @Test
    void discountToString() {
        assertThat(Discount.of(SPECIAL_DISCOUNT, LocalDateFactory.createLocalDateFrom("3"))
                .toString())
                .isEqualTo("특별 할인");
    }

    @DisplayName("할인가격이 0인 할인은 null을 반환")
    @Test
    void returnNull() {
        assertThat(Discount.of(SPECIAL_DISCOUNT, LocalDateFactory.createLocalDateFrom("2"))
                .toMessage()).isEqualTo(null);
    }
}
