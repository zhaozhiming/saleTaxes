package org.thoughtworks.homework;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriceUtilTest {
    @Test
    public void should_return_correct_price_scale() {
        assertThat(PriceUtil.setPriceScale(34.454), is(34.45));
        assertThat(PriceUtil.setPriceScale(34.456), is(34.46));
        assertThat(PriceUtil.setPriceScale(34.15), is(34.15));
        assertThat(PriceUtil.setPriceScale(34.1), is(34.10));
        assertThat(PriceUtil.setPriceScale(34), is(34.00));
    }
}
