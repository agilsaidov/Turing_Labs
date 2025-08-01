package projects;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime timeZone = ZonedDateTime.now(ZoneId.of("Europe/Istanbul"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedTime = timeZone.format(formatter);
        System.out.println("-------------------------------");
        System.out.println("Istanbul Time: "+ formattedTime);

        // Max and min values
        System.out.println("-------------------------------");
        System.out.println("MIN: "+LocalDate.MIN);
        System.out.println("MAX: "+ LocalDate.MAX);
        System.out.println("-------------------------------");

        // Ad gunu
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(2006,9,19);

        int days = 0;

        while(!birthday.equals(today)) {
            birthday = birthday.plusDays(1);
            days++;
        }

        System.out.println("Days: "+days);
        System.out.println("-------------------------------");

    }
}