package christmas.constants;

import static christmas.constants.SystemString.ERROR_PREFIX;

public enum ExceptionMessage {
    DATE_OUT_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR_PREFIX + message;
    }
}
