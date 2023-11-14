package christmas.constants;

import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemString.SUB_TITLE_FORMAT;

public enum SubTitle {
    MENUS("주문 메뉴"),
    REGULAR_PRICE("할인 전 총주문 금액"),
    FREE_GIFT("증정 메뉴"),
    BENEFIT_DETAILS("혜택 내역"),
    TOTAL_BENEFITS("총혜택 금액"),
    FINAL_PRICE("할인 후 예상 결제 금액"),
    DECEMBER_EVENT_BADGE(String.format("%d월 이벤트 배지", EVENT_MONTH.getValue()));

    private final String title;

    SubTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format(SUB_TITLE_FORMAT.toString(), title);
    }
}
