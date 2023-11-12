package christmas.constants;

public enum SystemConstant {
    EVENT_YEAR(2023),
    EVENT_MONTH(12);

    private final int value;

    SystemConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
