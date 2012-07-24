package org.thoughtworks.homework;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GoodUtilTest {
    @Test
    public void should_return_2_scale_number_when_given_any_currency() {
        assertThat(GoodUtil.getCorrectScaleCurrency(15.5987), is(15.60));
        assertThat(GoodUtil.getCorrectScaleCurrency(15.5), is(15.50));
        assertThat(GoodUtil.getCorrectScaleCurrency(15.5917), is(15.59));
        assertThat(GoodUtil.getCorrectScaleCurrency(15), is(15.00));
    }

    @Test
    public void should_return_format_number_string_when_given_any_currency() {
        assertThat(GoodUtil.formatCurrency(10), is("10.00"));
        assertThat(GoodUtil.formatCurrency(10.2), is("10.20"));
        assertThat(GoodUtil.formatCurrency(10.2568), is("10.26"));
    }
}
