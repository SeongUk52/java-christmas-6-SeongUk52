package christmas.constants;

public enum SystemMessage {
    DISH_FORMAT("%s %d개"),
    BENEFIT_FORMAT("%s: -%,d원"),
    FREE_GIFT("증정 이벤트");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
