package christmas.utils;

import static christmas.constants.ExceptionMessage.DATE;
import static christmas.constants.SystemConstant.END_OF_DAYS;
import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemConstant.EVENT_YEAR;
import static christmas.constants.SystemConstant.FIRST_OF_DAYS;

import java.time.LocalDate;

public class LocalDateFactory {
    private LocalDateFactory() {
    }

    private static LocalDate createLocalDateFrom(int date) {
        validateRange(date);
        return LocalDate.of(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), date);
    }

    public static LocalDate createLocalDateFrom(String date) {
        return createLocalDateFrom(Integer.parseInt(date));
    }

    private static void validateRange(int date) {
        if (!isInRange(date)) {
            throw new IllegalArgumentException(DATE.toString());
        }
    }

    private static boolean isInRange(int date) {
        return date > FIRST_OF_DAYS.getValue() && date < END_OF_DAYS.getValue();
    }
}
