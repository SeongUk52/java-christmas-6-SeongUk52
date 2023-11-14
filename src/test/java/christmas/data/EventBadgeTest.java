package christmas.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EventBadgeTest {

    private static Stream<Arguments> provideIntegerForEventBadge() {
        return Stream.of(
                Arguments.of(30, "없음"),
                Arguments.of(5654, "별"),
                Arguments.of(12304, "트리"),
                Arguments.of(46435, "산타")
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntegerForEventBadge")
    @DisplayName("조건별 12월 이벤트 배지")
    void getFreeGiftShouldReturnString(int input, String expected) {
        assertEquals(expected, EventBadge.DECEMBER_EVENT_BADGE_CONDITION.getFreeGift(input));
    }
}
