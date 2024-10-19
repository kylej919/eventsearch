-- hibernate can't create a spacial index like this, using custom startup script instead
-- in a real production setting, I'd use flyway or other schema management tool
-- https://medium.com/symphonyis/postgis-a-real-world-example-f99eaedf1462#dc9a
create index event_location_idx ON event using GIST(location);
