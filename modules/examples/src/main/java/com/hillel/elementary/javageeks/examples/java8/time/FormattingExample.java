package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class FormattingExample {
    public static void main(String[] args) {
        // 2014-04-01 10:45
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);

        // format as basic ISO date format (20140220)
        String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("BASIC_ISO_DATE: " + asBasicIsoDate);

        // format as ISO week date (2014-W08-4)
        String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);
        System.out.println("ISO_WEEK_DATE: " + asIsoWeekDate);

        // format ISO date time (2014-02-20T20:04:05.867)
        String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println("ISO_DATE_TIME: " + asIsoDateTime);

        // using a custom pattern (01/04/2014)
        String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("dd/MM/yyyy: " + asCustomPattern);

        // french date formatting (1. avril 2014)
        String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));
        System.out.println("French Date: " + frenchDate);

        // using short german date/time formatting (01.04.14 10:45)
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(new Locale("de"));
        String germanDateTime = dateTime.format(formatter);
        System.out.println("German Date: " + germanDateTime);

        // parsing date strings
        LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
        LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
        LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
