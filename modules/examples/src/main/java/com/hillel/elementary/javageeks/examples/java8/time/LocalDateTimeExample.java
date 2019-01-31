package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class LocalDateTimeExample {

    public static void main(String[] args) {
        // dates with times, e.g. 2014-02-18 19:08:37.950
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 2014-10-02 12:30
        LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);
        // 2014-12-24 12:00
        LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);


        LocalDateTime someDate = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek = someDate.getDayOfWeek();
        System.out.println(dayOfWeek);      // WEDNESDAY

        Month month = someDate.getMonth();
        System.out.println(month);          // DECEMBER

        long minuteOfDay = someDate.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);    // 1439

    }
}
