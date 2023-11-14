package christmas;

import christmas.contorller.EventPlannerController;
import christmas.domain.BenefitsManager;
import christmas.domain.Dish;
import christmas.domain.Dishes;
import christmas.utils.LocalDateFactory;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        EventPlannerController eventPlannerController = new EventPlannerController(new InputView(), new OutputView());
        eventPlannerController.play();
        System.out.println(BenefitsManager.of(LocalDateFactory.createLocalDateFrom("24"),
                Dishes.from(List.of(Dish.from("해산물파스타-2"),
                        Dish.from("레드와인-1"),
                        Dish.from("초코케이크-1")))).toStrings());
    }
}
