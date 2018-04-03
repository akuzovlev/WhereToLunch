DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS dishes;
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
  admin    BOOL DEFAULT FALSE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON users (email);

CREATE TABLE dishes (
  id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurantName TEXT   NOT NULL,
  description   TEXT      NOT NULL,
  price      FLOAT       NOT NULL
);
