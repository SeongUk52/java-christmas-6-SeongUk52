package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemConstant.BASIC_INIT_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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
        return sumByConditionFrom(Dish::calculatePrice);
    }

    public int calculateDishesAmount() {
        return sumByConditionFrom(Dish::getAmount);
    }

    private int sumByConditionFrom(Function<Dish, Integer> condition) {
        return dishes.stream()
                .map(condition)
                .reduce(BASIC_INIT_NUMBER.getValue(), Integer::sum);
    }

    public int calculateDiscountOf(String category, int discountAmount) {
        return dishes.stream()
                .filter(i -> i.is(category))
                .map(i -> i.calculateDiscountFrom(discountAmount))
                .reduce(BASIC_INIT_NUMBER.getValue(), Integer::sum);
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
