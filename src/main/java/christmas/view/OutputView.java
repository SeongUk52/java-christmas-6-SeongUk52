package christmas.view;

import static christmas.constants.SystemMessage.INIT_PLANNER;

public class OutputView {

    public void printInitMessage() {
        System.out.println(INIT_PLANNER);
    }

    public void printExceptionMessage(Exception message) {
        System.out.println(message.getMessage());
    }

}
