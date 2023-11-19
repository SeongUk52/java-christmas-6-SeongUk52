package christmas.data;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @DisplayName("없는 메뉴를 넣으면 예외처리")
    @Test
    void findByInvalidOrder() {
        assertThatThrownBy(() -> Menu.findBy("돼지국밥"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
