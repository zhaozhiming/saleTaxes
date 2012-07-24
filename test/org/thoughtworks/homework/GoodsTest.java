package org.thoughtworks.homework;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GoodsTest {
    @Test
    public void should_return_sales_taxes_and_price_when_given_goods_description() {
        Goods goods1 = new Goods("1 book at 12.49\n" +
                "1 music CD at 14.99\n" +
                "1 chocolate bar at 0.85");
        assertThat(goods1.salesTaxes(), is(1.5));
        assertThat(goods1.totalPrice(), is(29.83));

        Goods goods2 = new Goods("1 imported box of chocolates at 10.00\n" +
                "1 imported bottle of perfume at 47.50");
        assertThat(goods2.salesTaxes(), is(7.65));
        assertThat(goods2.totalPrice(), is(65.15));

        Goods goods3 = new Goods("1 imported bottle of perfume at 27.99\n" +
                "1 bottle of perfume at 18.99\n" +
                "1 packet of headache pills at 9.75\n" +
                "1 box of imported chocolates at 11.25");
        assertThat(goods3.salesTaxes(), is(6.70));
        assertThat(goods3.totalPrice(), is(74.68));
    }
}
