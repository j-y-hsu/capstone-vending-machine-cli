package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    void formatMoneyShouldReturnCorrectlyFormattedString() {
        BigDecimal test = new BigDecimal(10);
        String expected = "$10.00";
        String result = Utility.formatMoney(test);

        Assert.assertEquals(expected, result);
    }

    @Test
    void getReportDateTimeShouldReturnCorrectlyFormattedDateAsString() {
        
    }

    @Test
    void getLogDate() {
    }
}