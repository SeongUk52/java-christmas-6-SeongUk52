package christmas.contorller;

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
        //안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
        LocalDate localDate = inputWhileValid(inputView::readDate);
        Kiosk kiosk = inputWhileValid(() -> Kiosk.from((inputView.readDishes())));
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
