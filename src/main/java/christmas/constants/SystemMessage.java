package christmas.constants;

public enum SystemMessage {
    DISH_FORMAT("%s %d개");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
