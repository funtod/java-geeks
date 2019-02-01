package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateExample {

    public static void main(String[] args) {

        // the current date
        LocalDate today = LocalDate.now();
        // 2014-02-10
        LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);
        // months values start at 1 (2014-08-01)
        LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);
        // the 65th day of 2010 (2010-03-06)
        LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);

        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);    // FRIDAY


        LocalDate date = LocalDate.of(2014, 2, 15); // 2014-06-15
        Month february = date.getMonth(); // FEBRUARY
        int februaryIntValue = february.getValue(); // 2
        int minLength = february.minLength(); // 28
        int maxLength = february.maxLength(); // 29

        Month firstMonthOfQuarter = february.firstMonthOfQuarter(); // JANUARY

        int year = date.getYear(); // 2014
        int dayOfYear = date.getDayOfYear(); // 46
        int lengthOfYear = date.lengthOfYear(); // 365
        boolean isLeapYear = date.isLeapYear(); // false
    }
}
