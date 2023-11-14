package christmas.data;

import static christmas.data.DiscountData.CHRISTMAS_D_DAY;
import static christmas.data.DiscountData.SPECIAL_DISCOUNT;
import static christmas.data.DiscountData.WEEKDAY;
import static christmas.data.DiscountData.WEEKEND;
import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.Dish;
import christmas.domain.Dishes;
import christmas.utils.LocalDateFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class DiscountDataTest {

    private static Stream<Arguments> provideDateAndDishesForD_Day() {
        return Stream.of(
                Arguments.of(LocalDateFactory.createLocalDateFrom("25"), 3_400),
                Arguments.of(LocalDateFactory.createLocalDateFrom("1"), 1_000),
                Arguments.of(LocalDateFactory.createLocalDateFrom("26"), 0)
        );
    }

    private static Stream<Arguments> provideDateAndDishesForWeekDay() {
        return Stream.of(
                Arguments.of(LocalDateFactory.createLocalDateFrom("25"),
                        Dishes.createEmpty(), 0),
                Arguments.of(LocalDateFactory.createLocalDateFrom("13"),
                        Dishes.from(List.of(Dish.from("초코케이크-3"),
                                Dish.from("바비큐립-2"),
                                Dish.from("아이스크림-1"))), 2_023 * 4),
                Arguments.of(LocalDateFactory.createLocalDateFrom("29"),
                        Dishes.from(List.of(Dish.from("초코케이크-3"),
                                Dish.from("바비큐립-2"),
                                Dish.from("아이스크림-1"))), 0)
        );
    }

    private static Stream<Arguments> provideDateAndDishesForWeekEnd() {
        return Stream.of(
                Arguments.of(LocalDateFactory.createLocalDateFrom("16"),
                        Dishes.from(List.of(Dish.from("바비큐립-2"),
                                Dish.from("티본스테이크-1"))), 2_023 * 3),
                Arguments.of(LocalDateFactory.createLocalDateFrom("17"),
                        Dishes.from(List.of(Dish.from("바비큐립-2"),
                                Dish.from("티본스테이크-1"))), 0)
        );
    }

    private static Stream<Arguments> provideDateForSpecial() {
        return Stream.of(
                Arguments.of(LocalDateFactory.createLocalDateFrom("10"), 1_000),
                Arguments.of(LocalDateFactory.createLocalDateFrom("9"), 0),
                Arguments.of(LocalDateFactory.createLocalDateFrom("25"), 1_000)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDateAndDishesForD_Day")
    @DisplayName("크리스마스 디데이 할인 조건식")
    void dDayDiscount(LocalDate date, int result) {
        assertThat(CHRISTMAS_D_DAY.calculateDiscountAmount(date))
                .isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideDateAndDishesForWeekDay")
    @DisplayName("평일 할인 조건식")
    void weekDayDiscount(LocalDate date, Dishes dishes, int result) {
        assertThat(WEEKDAY.calculateDiscountAmount(date,
                dishes)).isEqualTo(result);
    }


    @ParameterizedTest
    @MethodSource("provideDateAndDishesForWeekEnd")
    @DisplayName("주말 할인 조건식")
    void weekEndDiscount(LocalDate date, Dishes dishes, int result) {
        assertThat(WEEKEND.calculateDiscountAmount(date, dishes)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("provideDateForSpecial")
    @DisplayName("특별 할인 조건식")
    void specialDiscount(LocalDate date, int result) {
        assertThat(SPECIAL_DISCOUNT.calculateDiscountAmount(date))
                .isEqualTo(result);
    }
}
