package com.hillel.elementary.javageeks.examples.java8.time;

import java.time.Instant;

public class InstantExample {
    public static void main(String[] args) {
        // current time
        Instant now = Instant.now();
        // from unix timestamp, 2010-01-01 12:00:00
        Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);
        // same time in millis
        Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000L);
        // parsing from ISO 8601
        Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");
        // toString() returns ISO 8601 format, e.g. 2014-02-15T01:02:03Z
        String toIso8601 = now.toString();
        // as unix timestamp
        long toUnixTimestamp = now.getEpochSecond();
        // in millis
        long toEpochMillis = now.toEpochMilli();
        // plus/minus methods are available too
        Instant nowPlusTenSeconds = now.plusSeconds(10);

        System.out.println(nowPlusTenSeconds);
    }
}
