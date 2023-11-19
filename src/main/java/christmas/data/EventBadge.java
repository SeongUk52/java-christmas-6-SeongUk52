package christmas.data;

import static christmas.constants.SystemMessage.NOTHING;

import java.util.function.Function;

public enum EventBadge {
    DECEMBER_EVENT_BADGE_CONDITION((regularPrice) -> {
        if (regularPrice >= 20_000) {
            return "산타";
        }

        if (regularPrice >= 10_000) {
            return "트리";
        }

        if (regularPrice >= 5_000) {
            return "별";
        }

        return NOTHING.toString();
    });

    private final Function<Integer, String> condition;

    EventBadge(Function<Integer, String> condition) {
        this.condition = condition;
    }

    public String applyEventBadge(int totalBenefits) {
        return condition.apply(totalBenefits);
    }
}
