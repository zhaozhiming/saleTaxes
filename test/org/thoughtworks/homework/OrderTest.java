package org.thoughtworks.homework;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OrderTest {

    @Test
    public void should_return_total_and_sales_taxes_when_given_input1_goods() {
        Goods book = new Goods(12.49, new NoTax());
        Goods musicCD = new Goods(14.99, new SalesTax(new NoTax()));
        Goods chocolateBar = new Goods(0.85, new NoTax());

        assertThat(book.afterTaxPrice(), is(12.49));
        assertThat(musicCD.afterTaxPrice(), is(16.49));
        assertThat(chocolateBar.afterTaxPrice(), is(0.85));

        List<Goods> goodsList = asList(book, musicCD, chocolateBar);
        Order order = new Order(goodsList);
        assertThat(order.salesTaxes(), is(1.50));
        assertThat(order.total(), is(29.83));
    }

    @Test
    public void should_return_total_and_sales_taxes_when_given_input2_goods() {
        Goods importChocolate = new Goods(10.00, new ImportTax(new NoTax()));
        Goods importPerfume = new Goods(47.50, new ImportTax(new SalesTax(new NoTax())));

        assertThat(importChocolate.afterTaxPrice(), is(10.50));
        assertThat(importPerfume.afterTaxPrice(), is(54.65));

        List<Goods> goodsList = asList(importChocolate, importPerfume);
        Order order = new Order(goodsList);
        assertThat(order.salesTaxes(), is(7.65));
        assertThat(order.total(), is(65.15));
    }

    @Test
    public void should_return_total_and_sales_taxes_when_given_many_tax_goods() {
        Goods importPerfume = new Goods(27.99, new ImportTax(new SalesTax(new NoTax())));
        Goods perfume = new Goods(18.99, new SalesTax(new NoTax()));
        Goods headachePill = new Goods(9.75, new NoTax());
        Goods chocolateBar = new Goods(11.25, new ImportTax(new NoTax()));

        assertThat(importPerfume.afterTaxPrice(), is(32.19));
        assertThat(perfume.afterTaxPrice(), is(20.89));
        assertThat(headachePill.afterTaxPrice(), is(9.75));
        assertThat(chocolateBar.afterTaxPrice(), is(11.85));

        List<Goods> goodsList = asList(importPerfume, perfume, headachePill, chocolateBar);
        Order order = new Order(goodsList);
        assertThat(order.salesTaxes(), is(6.70));
        assertThat(order.total(), is(74.68));
    }

}
