package com.kylej.eventsearch.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record GetEventsResponse(List<EventDto> events) {}
