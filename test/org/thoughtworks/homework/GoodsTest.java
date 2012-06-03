package org.thoughtworks.homework;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GoodsTest {
    @Test
    public void should_return_sale_price_when_given_no_tax_goods() {
        Goods book = new Goods(12.49, new NoTax());
        assertThat(book.taxMoney(), is(0d));
        assertThat(book.afterTaxPrice(), is(12.49));
    }

    @Test
    public void should_return_sale_tax_price_when_given_sale_tax_goods() {
        Goods musicCD = new Goods(14.99, new SalesTax(new NoTax()));
        assertThat(musicCD.taxMoney(), is(1.50));
        assertThat(musicCD.afterTaxPrice(), is(16.49));
    }

    @Test
    public void should_return_import_tax_price_when_given_import_tax_goods() {
        Goods importBook = new Goods(12.49, new ImportTax(new NoTax()));
        assertThat(importBook.taxMoney(), is(0.65));
        assertThat(importBook.afterTaxPrice(), is(13.14));
    }

    @Test
    public void should_return_sale_and_import_tax_price_when_given_sale_and_import_tax_goods() {
        Goods importMusicCD = new Goods(27.99, new ImportTax(new SalesTax(new NoTax())));
        assertThat(importMusicCD.taxMoney(), is(4.20));
        assertThat(importMusicCD.afterTaxPrice(), is(32.19));
    }
}
