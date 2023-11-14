package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemConstant.BASE_PRICE;

import java.util.List;
import java.util.stream.Stream;

public class Dishes {
    private final List<Dish> dishes;

    private Dishes(List<Dish> dishes) {
        validateDistinct(dishes);
        this.dishes = dishes;
    }

    public static Dishes from(List<Dish> dishes) {
        return new Dishes(dishes);
    }

    public static Dishes createEmpty() {
        return new Dishes(List.of());
    }

    private void validateDistinct(List<Dish> dishes) {
        if (!isDistinct(dishes)) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    private boolean isDistinct(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::getMenu)
                .distinct()
                .count() == dishes.size();
    }

    public int calculateRegularPrice() {
        return dishes.stream()
                .map(Dish::calculatePrice)
                .reduce(BASE_PRICE.getValue(), Integer::sum);
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public Stream<Dish> stream() {
        return dishes.stream();
    }
}
