package christmas.domain;

import static christmas.constants.ExceptionMessage.ORDER_EXCEPTION;
import static christmas.constants.SystemConstant.MIN_ORDER_QUANTITY;
import static christmas.constants.SystemMessage.DISH_FORMAT;
import static christmas.constants.SystemString.DISH_SEPARATOR;

import christmas.data.Menu;
import christmas.utils.Numeral;
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
        String[] splitedInput = menuAndAmount.split(DISH_SEPARATOR.toString());
        return Dish.from(splitedInput[0], splitedInput[1]);
    }

    private static Dish from(String menu, String amount) {
        validateNumral(amount);
        return new Dish(findMenuFrom(menu), Integer.parseInt(amount));
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

    public int calculateDiscountFrom(int discountPrice) {
        return amount * discountPrice;
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
