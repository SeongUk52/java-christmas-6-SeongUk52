package christmas.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class KioskTest {

    @DisplayName("메뉴 형식이 예시와 다른 경우 예외처리")
    @ValueSource(strings = {"", "타파스-1.제로콜라-1", "타파스-1\n제로콜라-1", "타파스-1,,,제로콜라-1",
            "타파스-1제로콜라-1", "타파스-0,제로콜라-1"})
    @ParameterizedTest
    void createKioskByInvalidInput(String input) {
        assertThatThrownBy(() -> Kiosk.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴의 예외처리")
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-1", "제로콜라-1,타파스-1,제로콜라-1"})
    @ParameterizedTest
    void createKioskByDuplicateInput(String input) {
        assertThatThrownBy(() -> Kiosk.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.")
    @Test
    void isApplyDiscount() {
        assertThat(Kiosk.from("시저샐러드-1").isApplyDiscount()).isFalse();
    }

    @DisplayName("음료만 주문 시, 주문할 수 없습니다.")
    @Test
    void isExceptionConditionByOnlyDrinks() {
        assertThat(Kiosk.from("제로콜라-3,샴페인-1").isExceptionCondition()).isTrue();
    }

    @DisplayName("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.")
    @Test
    void isExceptionConditionByMoreThan20() {
        assertThat(Kiosk.from("제로콜라-30,시저샐러드-1").isExceptionCondition()).isTrue();
    }
}
