package com.org.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class TimeUtil {
    public static void main(String[] args) {
        int year = LocalDate.now().getYear();
        int moth = LocalDate.now().getMonthValue();
        int day = LocalDate.now().getDayOfMonth();
        System.out.println(LocalDateTime.of(year, moth, day, 0, 0, 0));
        LocalDate lastDayOfThisMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()); // 2014-12-31
        System.out.println(lastDayOfThisMonth);
        System.out.println(year + ":" + moth + ":" + day);
        System.out.println("$$$$$$$$");
        System.out.println(LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate firstDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime firstTime = LocalDateTime.of(firstDate.getYear(), firstDate.getMonth(), firstDate.getDayOfMonth(), 0, 0, 0,0);
        System.out.println(firstTime);

        System.out.println(LocalDate.now());

    }
}
