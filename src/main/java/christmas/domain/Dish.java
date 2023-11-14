package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemConstant.MIN_ORDER_QUANTITY;
import static christmas.constants.SystemMessage.DISH_FORMAT;
import static christmas.constants.SystemString.DISH_SEPARATOR;

import christmas.data.Menu;
import christmas.utils.Numeral;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Dish {
    private final Menu menu;
    private final int amount;

    private Dish(Menu menu, int amount) {
        this.menu = menu;
        validateAmountRange(amount);
        this.amount = amount;
    }

    public static Dish from(String menuAndAmount) {
        validateMenuFormat(menuAndAmount);
        return Dish.from(Arrays.stream(menuAndAmount.split(DISH_SEPARATOR.toString())).toList());
    }

    private static Dish from(List<String> menuAndAmount) {
        validateNumral(menuAndAmount.get(1));
        return new Dish(findMenuFrom(menuAndAmount.get(0)), Integer.parseInt(menuAndAmount.get(1)));
    }

    private static Menu findMenuFrom(String menu) {
        return Menu.findBy(menu);
    }

    private static void validateMenuFormat(String menuAndAmount) {
        if (!menuAndAmount.contains(DISH_SEPARATOR.toString())) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    private static void validateNumral(String amount) {
        if (Numeral.notNumeral(amount)) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    private void validateAmountRange(int amount) {
        if (amount < MIN_ORDER_QUANTITY.getValue()) {
            throw new IllegalArgumentException(ORDER_EXCEPTION.toString());
        }
    }

    public int calculatePrice() {
        return menu.getPrice() * amount;
    }

    public boolean is(String categori) {
        return Objects.equals(menu.getCategory(), categori);
    }

    public String toMessage() {
        return String.format(DISH_FORMAT.toString(), menu.toString(), amount);
    }

    public Menu getMenu() {
        return menu;
    }

    public int getAmount() {
        return amount;
    }
}
