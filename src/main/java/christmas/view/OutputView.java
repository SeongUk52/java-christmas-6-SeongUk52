package christmas.view;

import static christmas.constants.SubTitle.BENEFIT_DETAILS;
import static christmas.constants.SubTitle.DECEMBER_EVENT_BADGE;
import static christmas.constants.SubTitle.FINAL_PRICE;
import static christmas.constants.SubTitle.FREE_GIFT;
import static christmas.constants.SubTitle.MENUS;
import static christmas.constants.SubTitle.REGULAR_PRICE;
import static christmas.constants.SubTitle.TOTAL_BENEFITS;
import static christmas.constants.SystemConstant.EVENT_MONTH;
import static christmas.constants.SystemMessage.INIT_DETAILS;
import static christmas.constants.SystemMessage.INIT_PLANNER;
import static christmas.constants.SystemMessage.NOTHING;
import static christmas.constants.SystemString.PRICE_FORMAT;
import static christmas.data.EventBadge.DECEMBER_EVENT_BADGE_CONDITION;

import christmas.domain.BenefitsManager;
import christmas.domain.Kiosk;
import java.time.LocalDate;
import java.util.List;

public class OutputView {

    public void printInitMessage() {
        System.out.println(INIT_PLANNER);
    }

    public void printExceptionMessage(Exception message) {
        System.out.println(message.getMessage());
    }

    public void printDetailsBeforeBenefits(Kiosk kiosk, LocalDate date) {
        System.out.printf(INIT_DETAILS.toString(), EVENT_MONTH.getValue(), date.getDayOfMonth());
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
        System.out.printf(PRICE_FORMAT.toString(), kiosk.calculateRegularPrice());
    }

    public void printDetailsAfterBenefits(BenefitsManager benefitsManager, Kiosk kiosk) {
        printFreeGift(benefitsManager);
        printBenefitDetails(benefitsManager);
        printTotalBenefits(benefitsManager);
        printFinalPrice(benefitsManager, kiosk);
        printDecemberEventBadge(benefitsManager);
    }

    private void printFreeGift(BenefitsManager benefitsManager) {
        System.out.println(FREE_GIFT);
        benefitsManager.freeGiftToStringListOptional()
                .orElse(List.of(NOTHING.toString()))
                .forEach(System.out::println);
    }

    private void printBenefitDetails(BenefitsManager benefitsManager) {
        System.out.println(BENEFIT_DETAILS);
        benefitsManager.toStrings()
                .orElse(List.of(NOTHING.toString()))
                .forEach(System.out::println);
    }

    private void printTotalBenefits(BenefitsManager benefitsManager) {
        System.out.println(TOTAL_BENEFITS);
        System.out.printf(PRICE_FORMAT.toString(), -benefitsManager.calculateTotalBenefits());
    }

    private void printFinalPrice(BenefitsManager benefitsManager, Kiosk kiosk) {
        System.out.println(FINAL_PRICE);
        System.out.printf(PRICE_FORMAT.toString(),
                kiosk.calculateRegularPrice() - benefitsManager.calculateTotalDiscounts());
    }

    private void printDecemberEventBadge(BenefitsManager benefitsManager) {
        System.out.println(DECEMBER_EVENT_BADGE);
        System.out.println(DECEMBER_EVENT_BADGE_CONDITION.applyEventBadge(benefitsManager.calculateTotalBenefits()));
    }
}
