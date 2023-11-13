package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.data.DiscountData;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {
    @DisplayName("문자열 변환 기능 테스트")
    @Test
    void DiscountToString() {
        assertThat(Discount.of(DiscountData.SPECIAL_DISCOUNT, LocalDate.ofEpochDay(2)).toString())
                .isEqualTo("특별 할인");
    }
}
