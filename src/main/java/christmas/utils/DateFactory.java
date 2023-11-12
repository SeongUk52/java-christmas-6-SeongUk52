package christmas.utils;

import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemConstant.EVENT_YEAR;

import java.util.Date;

public class DateFactory {
    private DateFactory() {
    }

    public static Date createDateFrom(String date) {
        return new Date(EVENT_YEAR.getValue(), EVENT_MONTH.getValue(), Integer.parseInt(date));
    }

    private void validate(String date) {

    }
}
