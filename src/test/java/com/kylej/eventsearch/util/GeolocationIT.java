package com.kylej.eventsearch.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.SloppyMath;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
class GeolocationIT {

    @Test
    void testDistanceBetweenTwoPoints() {
        double lat1 = 39.72884058735954, lon1 = -104.97909888942658;
        double lat2 = 39.72809796538634, lon2 = -104.97907743175467;
        double lat3 = 40.71173561583668, lon3 = -74.01336906355884;

        double distance = SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);
        log.info("Distance between point 1 and 2: {}", distance);

        log.info("Distance between point 1 and 3: {}", SloppyMath.haversinMeters(lat1, lon1, lat3, lon3));
    }

    @Test
    void testDate() {
        log.info("Date: {}", System.currentTimeMillis());
        int dayRange = 3;
        Date start = Date.from(Instant.now().minus(dayRange, ChronoUnit.DAYS));
        Date end = Date.from(Instant.now().plus(dayRange, ChronoUnit.DAYS));

        List<Date> dateList = List.of(Date.from(Instant.now()));

        List<Date> filteredDates = dateList.stream().filter(d -> d.after(start) && d.before(end)).toList();
        log.info("Filtered dates: {}", filteredDates);

        dateList = List.of(Date.from(Instant.now().plus(4, ChronoUnit.DAYS)));

        filteredDates = dateList.stream().filter(d -> d.after(start) && d.before(end)).toList();
        log.info("Filtered dates 2: {}", filteredDates);
    }
}
