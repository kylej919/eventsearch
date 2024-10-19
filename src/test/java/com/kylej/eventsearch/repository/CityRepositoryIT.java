package com.kylej.eventsearch.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "classpath:sql/us-cities.sql")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CityRepositoryIT {

    @Autowired private CityRepository cityRepository;

    @Test
    void testFindCities() {
        assertThat(cityRepository.findAll()).isNotEmpty();
    }
}
