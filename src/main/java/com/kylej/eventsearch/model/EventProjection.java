package com.kylej.eventsearch.model;

import java.sql.Date;

public interface EventProjection {
    String getTitle();
    long getDistance();
    Date getEventDate();
}
