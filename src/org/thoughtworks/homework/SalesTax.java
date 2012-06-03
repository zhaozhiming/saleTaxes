package org.thoughtworks.homework;

public class SalesTax implements Tax {

    public static final double SALE_TAX = 0.1;
    private Tax tax;

    public SalesTax(Tax tax) {
        this.tax = tax;
    }

    public double getTaxRate() {
        return tax.getTaxRate() + SALE_TAX;
    }
}
