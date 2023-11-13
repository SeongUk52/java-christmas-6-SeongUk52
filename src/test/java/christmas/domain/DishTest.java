package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DishTest {
    @DisplayName("1 이상의 숫자가 아닐 경우 예외처리")
    @ValueSource(strings = {"양송이수프-0", "시저샐러드-0"})
    @ParameterizedTest
    void createDishByOutRange(String input) {
        assertThatThrownBy(() -> Dish.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
