package christmas.constants;

public enum SystemString {
    ERROR_PREFIX("[ERROR] ");

    private final String string;

    SystemString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
