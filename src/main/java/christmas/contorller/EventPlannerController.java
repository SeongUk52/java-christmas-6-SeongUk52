package christmas.contorller;

import christmas.domain.BenefitsManager;
import christmas.domain.Kiosk;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.time.LocalDate;
import java.util.function.Supplier;

public class EventPlannerController {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlannerController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        outputView.printInitMessage();
        LocalDate localDate = inputWhileValid(inputView::readDate);
        Kiosk kiosk = inputWhileValid(() -> Kiosk.from((inputView.readDishes())));
        outputView.printDetailsBeforeBenefits(kiosk, localDate);

        BenefitsManager benefitsManager = BenefitsManager.createNoBenefits();
        if (kiosk.isApplyDiscount()) {
            benefitsManager = BenefitsManager.of(localDate, kiosk.toDishes());
        }
        outputView.printDatailsAfterBenefits(benefitsManager, kiosk);
    }

    private <T> T inputWhileValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e);
            }
        }
    }
}
