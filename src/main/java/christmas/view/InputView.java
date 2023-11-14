package christmas.view;

import static christmas.constants.SystemMessage.INPUT_VISIT_DATE;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.LocalDateFactory;
import java.time.LocalDate;

public class InputView {
    public LocalDate readDate() {
        System.out.println(INPUT_VISIT_DATE);
        return LocalDateFactory.createLocalDateFrom(Console.readLine());
    }
}
