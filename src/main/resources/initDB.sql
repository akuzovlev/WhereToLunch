DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
DROP TABLE IF EXISTS restaurants;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
  START 1000;

CREATE TABLE users
(
  id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR                 NOT NULL,
  email    VARCHAR                 NOT NULL,
  password VARCHAR                 NOT NULL,
  votetime TIMESTAMP               ,
  voterestaurantid INTEGER         ,
  admin    BOOL DEFAULT FALSE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE restaurants (
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name     VARCHAR                 NOT NULL,
  votes   INTEGER DEFAULT 0
);

CREATE TABLE dishes (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id INTEGER   NOT NULL,
  description   TEXT      NOT NULL,
  price      FLOAT       NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);
