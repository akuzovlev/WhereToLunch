DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS historyrecords;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 1000;

CREATE TABLE users
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR                 NOT NULL,
  email    VARCHAR                 NOT NULL,
  password VARCHAR                 NOT NULL,
  votedrestaurantid INTEGER         ,
  admin    BOOL DEFAULT FALSE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE restaurants (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR                 NOT NULL
);

CREATE TABLE dishes (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id INTEGER   NOT NULL,
  description   TEXT      NOT NULL,
  price      INTEGER       NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE historyrecords (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  datetime TIMESTAMP NOT NULL,
  record     VARCHAR                 NOT NULL,
  type VARCHAR NOT NULL
);