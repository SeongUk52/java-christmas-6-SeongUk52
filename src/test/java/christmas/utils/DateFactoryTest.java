package christmas.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DateFactoryTest {
    @DisplayName("범위를 벗어난 입력이 주어지면 예외처리")
    @ValueSource(strings = {"99", "0", "-12"})
    @ParameterizedTest
    void createDateFromOutRange(String input) {
        assertThatThrownBy(() -> DateFactory.createDateFrom(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
