package org.thoughtworks.homework;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class GoodUtil {

    public static double getCorrectScaleCurrency(double currency) {
        return new BigDecimal(currency).setScale(2, ROUND_HALF_UP).doubleValue();
    }


    public static String formatCurrency(double currency) {
        return String.format("%.2f", currency);
    }
}
