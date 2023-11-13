package christmas.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class KioskTest {

    @DisplayName("메뉴 형식이 예시와 다른 경우 예외처리")
    @ValueSource(strings = {"", "타파스-1.제로콜라-1", "타파스-1\n제로콜라-1", "타파스-1제로콜라-1", "타파스-0,제로콜라-1"})
    @ParameterizedTest
    void createKioskByInvalidInput(String input) {
        assertThatThrownBy(() -> Kiosk.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
