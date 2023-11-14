package christmas.contorller;

import christmas.domain.Kiosk;
import christmas.view.InputView;
import java.time.LocalDate;

public class EventPlannerController {
    private final InputView inputView;

    public EventPlannerController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        //안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
        LocalDate localDate = inputView.readDate();
        Kiosk.from(inputView.readDishes());
    }
}
