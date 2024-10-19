package com.kylej.eventsearch.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Point;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "us_cities",
        indexes = {@Index(columnList = "state")})
public class City {

    @Id private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private USState state;

    @Column(name = "pop_2010")
    private long population2010;

    @Column(name = "elev_in_ft")
    private int altitude;

    @Column(name = "wkb_geometry", columnDefinition = "geometry")
    private Point geo;

    @CreationTimestamp private Timestamp createdAt;
    @UpdateTimestamp private Timestamp modifiedAt;
}
