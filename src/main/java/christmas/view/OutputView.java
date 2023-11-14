package christmas.view;

import static christmas.constants.SubTitle.MENUS;
import static christmas.constants.SubTitle.REGULAR_PRICE;
import static christmas.constants.SystemMessage.INIT_DETAILS;
import static christmas.constants.SystemMessage.INIT_PLANNER;
import static christmas.constants.SystemString.PRICE_FROMAT;

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
        printRegularPrice(kiosk);
    }

    private void printMenus(Kiosk kiosk) {
        System.out.println(MENUS);
        kiosk.toStringList()
                .orElseThrow()
                .forEach(System.out::println);
    }

    private void printRegularPrice(Kiosk kiosk) {
        System.out.println(REGULAR_PRICE);
        System.out.printf(PRICE_FROMAT + "%n", kiosk.calculateRegularPrice());
    }
}
