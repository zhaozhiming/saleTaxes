package org.thoughtworks.homework;

import java.util.HashMap;
import java.util.Map;

import static org.thoughtworks.homework.GoodUtil.formatCurrency;
import static org.thoughtworks.homework.GoodUtil.getCorrectScaleCurrency;

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

    public String output() {
        String[] descriptionArray = descriptions.split("\n");
        StringBuilder output = new StringBuilder();
        for (String description : descriptionArray) {
            Good good = new Good(description);
            output.append(good.count()).append(" ").append(good.name()).append(": ")
                    .append(formatCurrency(good.priceAfterTax())).append("\n");
        }
        output.append("Sales Taxes: ").append(formatCurrency(salesTaxes())).append("\n");
        output.append("Total: ").append(formatCurrency(totalPrice()));
        return output.toString();
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
