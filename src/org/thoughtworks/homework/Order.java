package org.thoughtworks.homework;

import java.util.List;

import static org.thoughtworks.homework.Order.Sum.AFTER_TAX_PRICE;
import static org.thoughtworks.homework.Order.Sum.TAX;

public class Order {

    private List<Goods> goodsList;

    public Order(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public double total() {
        return AFTER_TAX_PRICE.sum(goodsList);
    }

    public double salesTaxes() {
        return TAX.sum(goodsList);
    }

    enum Sum {
        TAX {
            @Override
            protected double neededPrice(Goods goods) {
                return goods.taxMoney();
            }
        }, AFTER_TAX_PRICE {
            @Override
            protected double neededPrice(Goods goods) {
                return goods.afterTaxPrice();
            }
        };

        private double sum(List<Goods> goodsList) {
            double result = 0;
            for (Goods goods : goodsList) {
                result += neededPrice(goods);
            }
            return PriceUtil.setPriceScale(result);
        }

        protected abstract double neededPrice(Goods goods);
    }
}
