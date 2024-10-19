package com.kylej.eventsearch.dto;

import java.sql.Date;

import com.kylej.eventsearch.model.EventType;
import lombok.Builder;

@Builder(toBuilder = true)
public record CreateEventRequest(
        String title, Date date, EventType eventType, long latitude, long longitude) {}
