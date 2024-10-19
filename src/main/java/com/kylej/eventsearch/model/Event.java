package com.kylej.eventsearch.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.locationtech.jts.geom.Point;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Date date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EventType type;

    /**
     * @see <a href="https://stackoverflow.com/a/32680922">Defining a point type in hibernate</a>
     */
    @Column(columnDefinition = "geometry", nullable = false)
    private Point location;

    @CreationTimestamp
    private Timestamp createdAt;
    @UpdateTimestamp
    private Timestamp modifiedAt;
}
