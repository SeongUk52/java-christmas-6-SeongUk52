package christmas.view;

import static christmas.constants.ExceptionMessage.DATE_EXCEPTION;
import static christmas.constants.SystemMessage.INPUT_VISIT_DATE;

import camp.nextstep.edu.missionutils.Console;
import christmas.utils.LocalDateFactory;
import christmas.utils.Numeral;
import java.time.LocalDate;

public class InputView {
    public LocalDate readDate() {
        System.out.println(INPUT_VISIT_DATE);
        String userInput = Console.readLine();
        validateNumeral(userInput);
        return LocalDateFactory.createLocalDateFrom(userInput);
    }

    private void validateNumeral(String userInput) {
        if (!Numeral.isNumeral(userInput)) {
            throw new IllegalArgumentException(DATE_EXCEPTION.toString());
        }
    }
}
