package christmas.constants;

import static christmas.constants.DiscountConstant.CHRISTMAS_D_DAY;
import static christmas.constants.DiscountConstant.SPECIAL_DISCOUNT;
import static christmas.constants.DiscountConstant.WEEKDAY;
import static christmas.constants.DiscountConstant.WEEKEND;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Dish;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountConstantTest {
    @DisplayName("크리스마스 디데이 할인 조건식")
    @Test
    void dDayDiscount() {
        assertThat(CHRISTMAS_D_DAY.calculateDiscountAmount(LocalDate.ofEpochDay(24))).isEqualTo(3400);
    }

    @DisplayName("평일 할인 조건식")
    @Test
    void weekDayDiscount() {
        assertThat(WEEKDAY.calculateDiscountAmount(LocalDate.ofEpochDay(12), List
                .of(Dish.from("초코케이크-3"),
                        Dish.from("바비큐립-2"),
                        Dish.from("아이스크림-1")))).isEqualTo(2_023 * 4);
    }

    @DisplayName("주말 할인 조건식")
    @Test
    void weekEndDiscount() {
        assertThat(WEEKEND.calculateDiscountAmount(LocalDate.ofEpochDay(15), List
                .of(Dish.from("바비큐립-2"),
                        Dish.from("티본스테이크-1")))).isEqualTo(2_023 * 3);
    }

    @DisplayName("특별 할인 조건식")
    @Test
    void specialDiscount() {
        assertThat(SPECIAL_DISCOUNT.calculateDiscountAmount(LocalDate.ofEpochDay(9)))
                .isEqualTo(1_000);
    }
}
