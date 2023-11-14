package christmas.view;

import static christmas.constants.SubTitle.FREE_GIFT;
import static christmas.constants.SubTitle.MENUS;
import static christmas.constants.SubTitle.REGULAR_PRICE;
import static christmas.constants.SystemMessage.INIT_DETAILS;
import static christmas.constants.SystemMessage.INIT_PLANNER;
import static christmas.constants.SystemMessage.NOTHING;
import static christmas.constants.SystemString.PRICE_FROMAT;

import christmas.domain.BenefitsManager;
import christmas.domain.Kiosk;
import java.util.List;

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

    public void printDatailsAfterBenefits(BenefitsManager benefitsManager) {
        printFreeGift(benefitsManager);
    }

    private void printFreeGift(BenefitsManager benefitsManager) {
        System.out.println(FREE_GIFT);
        benefitsManager.freeGiftToStringListOptional()
                .orElse(List.of(NOTHING.toString()))
                .forEach(System.out::println);
    }
}
