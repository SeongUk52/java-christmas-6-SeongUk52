package christmas.constants;

public enum SystemString {
    ERROR_PREFIX("[ERROR] "),
    DISH_SEPARATOR("-"),
    KIOSK_SEPARATOR(","),
    SUB_TITLE_FORMAT("\n<%s>");

    private final String string;

    SystemString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
