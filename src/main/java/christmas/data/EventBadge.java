package christmas.data;

import java.util.function.Function;

public enum EventBadge {
    DECEMBER_EVENT_BADGE((regularPrice) -> {
        if (regularPrice >= 20_000) {
            return "산타";
        }
        if (regularPrice >= 10_000) {
            return "트리";
        }
        if (regularPrice >= 5_000) {
            return "별";
        }
        return null;
    });

    private final Function<Integer, String> condition;

    EventBadge(Function<Integer, String> condition) {
        this.condition = condition;
    }

    public String getFreeGift(int totalBenefits) {
        return condition.apply(totalBenefits);
    }
}
