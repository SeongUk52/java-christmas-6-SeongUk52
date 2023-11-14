package christmas.view;

import static christmas.constants.SubTitle.MENUS;
import static christmas.constants.SystemMessage.INIT_DETAILS;
import static christmas.constants.SystemMessage.INIT_PLANNER;

import christmas.domain.Kiosk;

public class OutputView {

    public void printInitMessage() {
        System.out.println(INIT_PLANNER);
    }

    public void printExceptionMessage(Exception message) {
        System.out.println(message.getMessage());
    }

    public void printDetailsBeforeBenefits(Kiosk kiosk) {
        System.out.println(INIT_DETAILS);
        printMenus(kiosk);
    }

    private void printMenus(Kiosk kiosk) {
        System.out.println(MENUS);
        kiosk.toStringList()
                .forEach(System.out::println);
    }
}
