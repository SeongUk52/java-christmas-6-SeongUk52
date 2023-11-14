package christmas.constants;

public enum SystemMessage {
    DISH_FORMAT("%s %d개"),
    BENEFIT_FORMAT("%s: -%,d원"),
    FREE_GIFT("증정 이벤트"),
    INPUT_VISIT_DATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
