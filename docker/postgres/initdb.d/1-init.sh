#!/bin/bash
ogr2ogr -f "PostgreSQL" PG:"dbname=postgres user=postgres password=abc123" /docker-entrypoint-initdb.d/us_cities.geojson -lco FID=id -nln us_cities