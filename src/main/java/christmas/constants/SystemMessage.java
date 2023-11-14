package christmas.constants;

import static christmas.constants.SystemConstant.EVENT_MONTH;

public enum SystemMessage {
    DISH_FORMAT("%s %d개"),
    BENEFIT_FORMAT("%s: -%,d원"),
    FREE_GIFT("증정 이벤트"),
    INPUT_VISIT_DATE(String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", EVENT_MONTH.getValue())),
    INPUT_DISHES("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    INIT_PLANNER(String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", EVENT_MONTH.getValue())),
    INIT_DETAILS("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n"),
    NOTHING("없음");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
