package com.huawei.lecture;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateTime {

    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        long currentMillis = clock.millis();

        Instant currentInstant = clock.instant();


        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.APRIL,16, 1, 0);
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime tomorrow = now.plus(1, ChronoUnit.DAYS);

        Instant instant = tomorrow.atZone(ZoneId.systemDefault()).toInstant();

        Date date = Date.from(instant);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = dateTimeFormatter.format(tomorrow);
        System.out.println(dateTimeString);
    }
}
