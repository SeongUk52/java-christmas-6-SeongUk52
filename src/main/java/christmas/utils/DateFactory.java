package christmas.utils;

import static christmas.constants.SystemConstant.END_OF_DAYS;
import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemConstant.EVENT_YEAR;
import static christmas.constants.SystemConstant.FIRST_OF_DAYS;

import java.util.Date;

public class DateFactory {
    private DateFactory() {
    }

    private static Date createDateFrom(int date) {
        validateRange(date);
        return new Date(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), date);
    }

    public static Date createDateFrom(String date) {
        return createDateFrom(Integer.parseInt(date));
    }

    private static void validateRange(int date) {
        if (!isInRange(date)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isInRange(int date) {
        return date > FIRST_OF_DAYS.getValue() && date < END_OF_DAYS.getValue();
    }
}
