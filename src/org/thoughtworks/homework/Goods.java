package org.thoughtworks.homework;

import static org.thoughtworks.homework.PriceUtil.setPriceScale;

public class Goods {

    public static final double TAX_PRICE_MIN_UNIT = 0.05;

    private double price;
    private Tax tax;

    public Goods(double price, Tax tax) {
        this.price = price;
        this.tax = tax;
    }

    public double afterTaxPrice() {
        return setPriceScale(price + taxMoney());
    }

    public double taxMoney() {
        double taxMoney = setPriceScale(price * tax.getTaxRate());
        double modMoney = taxMoney % TAX_PRICE_MIN_UNIT;
        return (modMoney == 0) ? taxMoney : roundUpTax(taxMoney, modMoney);
    }

    private double roundUpTax(double taxMoney, double modMoney) {
        return taxMoney + (TAX_PRICE_MIN_UNIT - modMoney);
    }

}
