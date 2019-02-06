package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeExample {

    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now(); // current time
        LocalTime midday = LocalTime.of(12, 0); // 12:00
        LocalTime afterMidday = LocalTime.of(13, 30, 15); // 13:30:15
        // 12345th second of day (03:25:45)
        LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);

        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());


        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -180

    }
}
