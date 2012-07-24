package org.thoughtworks.homework;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GoodTest {
    @Test
    public void should_return_good_name_when_given_description() {
        assertThat(new Good("1 book at 12.49").name(), is("book"));
        assertThat(new Good("1 music CD at 14.99").name(), is("music CD"));
        assertThat(new Good("1 imported bottle of perfume at 27.99").name(), is("imported bottle of perfume"));
    }

    @Test
    public void should_return_good_price_when_given_description() {
        assertThat(new Good("1 book at 12.49").price(), is(12.49));
        assertThat(new Good("1 music CD at 14.99").price(), is(14.99));
        assertThat(new Good("1 imported bottle of perfume at 27.99").price(), is(27.99));
    }

    @Test
    public void should_return_good_count_when_given_description() {
        assertThat(new Good("1 book at 12.49").count(), is(1));
        assertThat(new Good("1 music CD at 14.99").count(), is(1));
        assertThat(new Good("1 imported bottle of perfume at 27.99").count(), is(1));
    }

    @Test
    public void should_return_good_is_imported_when_given_description() {
        assertThat(new Good("1 book at 12.49").isImported(), is(false));
        assertThat(new Good("1 imported bottle of perfume at 27.99").isImported(), is(true));
    }

    @Test
    public void should_return_good_is_exempt_when_given_description() {
        assertThat(new Good("1 book at 12.49").isExempt(), is(true));
        assertThat(new Good("1 chocolate bar at 0.85").isExempt(), is(true));
        assertThat(new Good("1 packet of headache pills at 9.75").isExempt(), is(true));
        assertThat(new Good("1 imported bottle of perfume at 27.99").isExempt(), is(false));
    }

    @Test
    public void should_return_good_tax_when_given_description() {
        assertThat(new Good("1 book at 12.49").tax(), is(0D));
        assertThat(new Good("1 music CD at 14.99").tax(), is(1.5));
        assertThat(new Good("1 imported box of chocolates at 10.00").tax(), is(0.5));
        assertThat(new Good("1 imported bottle of perfume at 27.99").tax(), is(4.20));
    }

    @Test
    public void should_return_good_price_after_tax_when_given_description() {
        assertThat(new Good("1 book at 12.49").priceAfterTax(), is(12.49));
        assertThat(new Good("1 music CD at 14.99").priceAfterTax(), is(16.49));
        assertThat(new Good("1 imported box of chocolates at 10.00").priceAfterTax(), is(10.5));
        assertThat(new Good("1 imported bottle of perfume at 27.99").priceAfterTax(), is(32.19));
    }
}
