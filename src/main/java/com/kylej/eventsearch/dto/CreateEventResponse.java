package com.kylej.eventsearch.dto;


import lombok.Builder;

@Builder
public record CreateEventResponse(CreateEventDto event) {}
