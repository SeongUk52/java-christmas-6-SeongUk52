package christmas.utils;

import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemConstant.EVENT_YEAR;

import java.util.Date;

public class DateFactory {
    private DateFactory() {
    }

    public static Date createDateFrom(int date) {
        return new Date(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), date);
    }
}
