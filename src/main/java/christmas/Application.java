package christmas;

import christmas.domain.BenefitsManager;
import christmas.domain.Dish;
import christmas.domain.Dishes;
import christmas.utils.LocalDateFactory;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(BenefitsManager.of(LocalDateFactory.createLocalDateFrom("24"),
                Dishes.from(List.of(Dish.from("해산물파스타-2"),
                        Dish.from("레드와인-1"),
                        Dish.from("초코케이크-1")))).toStrings());
    }
}
