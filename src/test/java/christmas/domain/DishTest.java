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

    @DisplayName("메뉴 형식이 예시와 다른 경우 예외처리하는지 테스트")
    @ValueSource(strings = {"양송이수프=5", "3-시저샐러드", "양송이수프----20", "양송이수프", "3", "양송이 수프 - 3"})
    @ParameterizedTest
    void createDishByIllegalInput(String input) {
        assertThatThrownBy(() -> Dish.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
