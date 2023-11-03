package com.techelevator;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String formatMoney(BigDecimal money) {
        return String.format("$%.2f", money);
    }

    public static String getReportDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getLogDate(){

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date date = new Date();
        return formatter.format(date);
    }


}
