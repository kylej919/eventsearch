package com.kylej.eventsearch.dto;


import lombok.Builder;

import java.util.Date;

@Builder
public record EventDto(String title, Date date, long distanceInMeters) {
}
