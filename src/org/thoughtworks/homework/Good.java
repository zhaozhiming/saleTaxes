package org.thoughtworks.homework;


import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.math.BigDecimal.ROUND_HALF_UP;
import static java.util.Arrays.asList;

public class Good {
    private static final String GOOD_DESCRIPTION_REGEX = "(\\d+)\\s((\\w+\\s)+)at\\s(\\d+.\\d+)";
    private static final String IMPORTED_KEYWORD = "imported";
    public static final List<String> EXEMPT_KEYWORD = asList("book", "chocolate", "pill");
    private String description;

    public Good(String description) {
        this.description = description;
    }

    public String name() {
        return matchDescription().group(2).trim();
    }

    public double price() {
        return Double.valueOf(matchDescription().group(4));
    }

    public int count() {
        return Integer.valueOf(matchDescription().group(1));
    }

    public boolean isImported() {
        return name().contains(IMPORTED_KEYWORD);
    }

    public boolean isExempt() {
        String goodName = name();
        boolean isExempt = false;
        for (String keyword : EXEMPT_KEYWORD) {
            isExempt = isExempt || goodName.contains(keyword);
        }
        return isExempt;
    }

    public double tax() {
        double taxFactor = isExempt() ? 0 : 0.1;
        taxFactor += isImported() ? 0.05 : 0;
        double tax = price() * taxFactor;
        double mod = tax % 0.05;
        tax += (mod == 0) ? 0 : (0.05 - mod);
        return getCorrectScaleCurrency(tax);
    }

    public double priceAfterTax() {
        return getCorrectScaleCurrency(price() + tax());
    }

    public static double getCorrectScaleCurrency(double currency) {
        return new BigDecimal(currency).setScale(2, ROUND_HALF_UP).doubleValue();
    }

    private Matcher matchDescription() {
        Pattern pattern = Pattern.compile(GOOD_DESCRIPTION_REGEX);
        Matcher matcher = pattern.matcher(description);
        matcher.find();
        return matcher;
    }
}
