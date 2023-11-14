package christmas.utils;

import java.util.regex.Pattern;

public class Numeral {
    private static final Pattern NUMERAL = Pattern.compile("[0-9]+");

    private Numeral() {
    }

    public static boolean notNumeral(String s) {
        return !NUMERAL.matcher(s).matches();
    }
}
