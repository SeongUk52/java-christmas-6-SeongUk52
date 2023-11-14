package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemConstant.BASE_PRICE;

import java.util.Collections;
import java.util.List;

public class Dishes {
    private final List<Dish> dishes;

    private Dishes(List<Dish> dishes) {
        validateDistinct(dishes);
        this.dishes = Collections.unmodifiableList(dishes);
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

    public int calculatePrice() {
        return dishes.stream()
                .map(Dish::calculatePrice)
                .reduce(BASE_PRICE.getValue(), Integer::sum);
    }

    public int calculateDishesAmount() {
        return dishes.stream()
                .map(Dish::getAmount)
                .reduce(0, Integer::sum);
    }

    public int calculateDiscountOf(String categori, int discountAmount) {
        return dishes.stream()
                .filter(i -> i.is(categori))
                .map(i -> i.calculateDiscountFrom(discountAmount))
                .reduce(0, Integer::sum);
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<String> toMessages() {
        return dishes.stream()
                .map(Dish::toMessage)
                .toList();
    }

    public boolean isAllMatch(String categori) {
        return dishes.stream()
                .allMatch(i -> i.is(categori));
    }
}
