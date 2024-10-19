CREATE INDEX city_location_idx ON us_cities using GIST(wkb_geometry);
