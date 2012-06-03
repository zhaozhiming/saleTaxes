package org.thoughtworks.homework;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class PriceUtil {

    public static final int PRICE_SCALE = 2;

    public static double setPriceScale(double price) {
        return new BigDecimal(price).setScale(PRICE_SCALE, ROUND_HALF_UP).doubleValue();
    }
}
