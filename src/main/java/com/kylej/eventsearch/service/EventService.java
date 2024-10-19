package com.kylej.eventsearch.service;

import java.util.List;

import com.kylej.eventsearch.dto.CreateEventRequest;
import com.kylej.eventsearch.model.Event;
import com.kylej.eventsearch.model.EventProjection;
import com.kylej.eventsearch.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    public static final GeometryFactory GEOMETRY_FACTORY =
            new GeometryFactory(new PrecisionModel());

    private final EventRepository eventRepository;

    public List<Event> findAround(double latitude, double longitude, double radiusMeters) {
        Point p = GEOMETRY_FACTORY.createPoint(new Coordinate(latitude, longitude));
        return eventRepository.findAllWithinRadius(p, radiusMeters);
    }

    public List<EventProjection> findEvents(double latitude, double longitude, double radiusMeters) {
        Point p = GEOMETRY_FACTORY.createPoint(new Coordinate(latitude, longitude));
        return eventRepository.findAllWithDistance(p, radiusMeters);
    }

    public Event createEvent(CreateEventRequest request) {
        Event event = Event.builder()
                .title(request.title())
                .date(request.date())
                .type(request.eventType())
                .location(GEOMETRY_FACTORY.createPoint(new Coordinate(request.latitude(), request.longitude())))
                .build();
        return eventRepository.save(event);
    }
}
