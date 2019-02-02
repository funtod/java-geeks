package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class PeriodsAndDuration {
    public static void main(String[] args) {
        // periods
        LocalDate firstDate = LocalDate.of(2010, 5, 17); // 2010-05-17
        LocalDate secondDate = LocalDate.of(2015, 3, 7); // 2015-03-07
        Period period = Period.between(firstDate, secondDate);
        int days = period.getDays(); // 18
        int months = period.getMonths(); // 9
        int years = period.getYears(); // 4
        boolean isNegative = period.isNegative(); // false

        Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
        LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);
        // add two months and five days to 2014-01-06, result is 2014-03-11
        LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);


        // durations
        Instant firstInstant= Instant.ofEpochSecond( 1294881180 ); // 2011-01-13 01:13
        Instant secondInstant = Instant.ofEpochSecond(1294708260); // 2011-01-11 01:11
        Duration between = Duration.between(firstInstant, secondInstant);
        // negative becaus  e firstInstant is after secondInstant (-172920)
        long seconds = between.getSeconds();
        // get absolute result in minutes (2882)
        long absoluteResult = between.abs().toMinutes();
        // two hours in seconds (7200)
        long twoHoursInSeconds = Duration.ofHours(2).getSeconds();
    }
}
