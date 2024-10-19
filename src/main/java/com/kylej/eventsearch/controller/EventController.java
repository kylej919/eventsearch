package com.kylej.eventsearch.controller;

import java.util.List;

import com.kylej.eventsearch.dto.*;
import com.kylej.eventsearch.model.Event;
import com.kylej.eventsearch.model.EventProjection;
import com.kylej.eventsearch.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/v1/event")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public GetEventsResponse getEvents(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int radiusMiles) {
        log.info("Getting events");
        List<EventProjection> events = eventService.findEvents(latitude, longitude, radiusMiles);
        List<EventDto> eventDtos = events.stream().map(EventController::toDto).toList();
        return GetEventsResponse.builder().events(eventDtos).build();
    }

    @PostMapping
    public CreateEventResponse createEvent(@RequestBody CreateEventRequest request) {
        log.info("Creating event {}", request.title());
        Event event = eventService.createEvent(request);
        return CreateEventResponse.builder().event(toCreateEventDto(event)).build();
    }

    private static EventDto toDto(EventProjection event) {
        return EventDto.builder()
                .title(event.getTitle())
                .date(event.getEventDate())
                .distanceInMeters(event.getDistance())
                .build();
    }

    private static CreateEventDto toCreateEventDto(Event event) {
        return CreateEventDto.builder()
                .title(event.getTitle())
                .date(event.getDate())
                .createdOn(event.getCreatedAt())
                .build();
    }
}
