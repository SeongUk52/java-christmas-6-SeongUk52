package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DishesTest {

    @DisplayName("할인 전 총 주문 금액을 계산하는 기능")
    @Test
    void calculateTotalPriceBeforeBenefits() {
        assertThat(Dishes.from(List.of(Dish.from("타파스-1"), Dish.from("제로콜라-1")))
                .calculateRegularPrice())
                .isEqualTo(8500);
    }
}
