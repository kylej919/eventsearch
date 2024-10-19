package com.kylej.eventsearch.repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import com.kylej.eventsearch.model.Event;
import com.kylej.eventsearch.model.EventProjection;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, UUID> {

    @Query(
            value =
                    "SELECT * FROM {h-schema}event e WHERE ST_DistanceSphere(e.location, :origin) < :radiusMeters",
            nativeQuery = true)
    List<Event> findAllWithinRadius(Point origin, double radiusMeters);

    @Query(
            value =
                    """
              with event_details as
                  (SELECT *, ST_DistanceSphere(e.location::geometry, ST_MakePoint(40.71173561583668, -74.01336906355884)) as distance
                   from event e)
              select ed.title as title, ed.distance as distance, ed.date as eventDate from event_details ed""",
            nativeQuery = true)
    List<EventProjection> findAllWithDistance(Point origin, double radiusMeters);

    @Query("SELECT e FROM Event e WHERE e.date BETWEEN :start AND :end")
    List<Event> findByDateBetween(Date start, Date end);
}
