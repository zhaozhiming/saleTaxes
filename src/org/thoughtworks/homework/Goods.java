package org.thoughtworks.homework;

import java.util.HashMap;
import java.util.Map;

import static org.thoughtworks.homework.Good.getCorrectScaleCurrency;

public class Goods {

    public static final String SALES_TAXES = "salesTaxes";
    public static final String TOTAL_PRICE = "totalPrice";
    private String descriptions;

    public Goods(String descriptions) {
        this.descriptions = descriptions;
    }

    public double salesTaxes() {
        return salesTaxesAndTotalPrice().get(SALES_TAXES);
    }

    public double totalPrice() {
        return salesTaxesAndTotalPrice().get(TOTAL_PRICE);
    }

    private Map<String, Double> salesTaxesAndTotalPrice() {
        String[] descriptionArray = descriptions.split("\n");
        double salesTaxes = 0;
        double totalPrice = 0;
        for (String description : descriptionArray) {
            Good good = new Good(description);
            salesTaxes += good.tax();
            totalPrice += good.priceAfterTax();
        }
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put(SALES_TAXES, getCorrectScaleCurrency(salesTaxes));
        result.put(TOTAL_PRICE, getCorrectScaleCurrency(totalPrice));
        return result;
    }
}
