package com.kylej.eventsearch.dto;

import lombok.Builder;

import java.util.Date;

@Builder
public record CreateEventDto(String title, Date date, Date createdOn) {}
