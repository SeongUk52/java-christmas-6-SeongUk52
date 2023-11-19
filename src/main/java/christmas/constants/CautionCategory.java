package christmas.constants;

public enum CautionCategory {
    EVENT_THROW_ILLEGAL_ARGUMENT_EXCEPTION,
    EVENT_DISCOUNT_APPLIED;

    public boolean equals(CautionCategory category) {
        return this.name().equals(category.name());
    }
}
