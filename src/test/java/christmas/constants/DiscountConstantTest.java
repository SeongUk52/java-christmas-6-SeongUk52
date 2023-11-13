package christmas.constants;

import static christmas.constants.DiscountConstant.CHRISTMAS_D_DAY;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountConstantTest {
    @DisplayName("크리스마스 디데이 할인 조건식")
    @Test
    void D_DayDiscount() {
        assertThat(CHRISTMAS_D_DAY.calculateDiscountAmount(LocalDate.ofEpochDay(24))).isEqualTo(3400);
    }
}
