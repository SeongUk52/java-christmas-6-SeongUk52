package christmas.data;

import static christmas.data.FreeGiftData.CHRISTMAS_CHAMPAGNE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FreeGiftDataTest {

    @Test
    @DisplayName("할인 전 가격 12만원 이상이면 증정품 샴페인 반환")
    void getFreeGiftShouldReturnDish() {
        assertEquals("샴페인", CHRISTMAS_CHAMPAGNE.getFreeGift(150_000).getMenu().toString());
    }

    @Test
    @DisplayName("할인 전 가격 12만원 미만이면 null 반환")
    void getFreeGiftShouldReturnNull() {
        assertNull(CHRISTMAS_CHAMPAGNE.getFreeGift(119_000));
    }
}
