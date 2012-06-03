package org.thoughtworks.homework;

public class ImportTax implements Tax {

    public static final double IMPORT_TAX = 0.05;
    private Tax tax;

    public ImportTax(Tax tax) {
        this.tax = tax;
    }

    public double getTaxRate() {
        return tax.getTaxRate() + IMPORT_TAX;
    }
}
