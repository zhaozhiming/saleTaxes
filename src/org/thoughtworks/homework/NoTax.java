package org.thoughtworks.homework;

public class NoTax implements Tax {

    public static final int NO_TAX = 0;

    public double getTaxRate() {
        return NO_TAX;
    }
}
