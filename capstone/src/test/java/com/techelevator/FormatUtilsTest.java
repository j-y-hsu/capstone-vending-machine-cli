package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class FormatUtilsTest {

    @Test
    void formatMoneyShouldReturnCorrectlyFormattedString() {
        BigDecimal test = new BigDecimal(10);
        String expected = "$10.00";
        String result = FormatUtils.formatMoney(test);

        Assert.assertEquals(expected, result);
    }

    @Test
    void getReportDateTimeShouldReturnCorrectlyFormattedDateAsString() {
        String test = FormatUtils.getReportDateTime();
        String pattern = "[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])_(2[0-3]|[01][0-9])-[0-5][0-9]-[0-5][0-9]";

        Assert.assertTrue(test.matches(pattern));
    }

    @Test
    void getLogDateShouldReturnCorrectlyFormattedDateAsString() {
        String test = FormatUtils.getLogDate();
        String pattern = "\\d{1,2}\\/\\d{1,2}\\/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2} [AP]M";

        Assert.assertTrue(test.matches(pattern));
    }
}