package christmas;

import christmas.contorller.EventPlannerController;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        var eventPlannerController = new EventPlannerController(new InputView(), new OutputView());
        eventPlannerController.play();
    }
}
