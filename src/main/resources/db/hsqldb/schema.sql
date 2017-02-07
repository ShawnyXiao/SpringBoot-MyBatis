DROP TABLE book IF EXISTS;
DROP TABLE book_store IF EXISTS;
DROP TABLE user IF EXISTS;

CREATE TABLE book (
  id            BIGINT IDENTITY PRIMARY KEY,
  book_store_id BIGINT,
  name          VARCHAR(80),
  author        VARCHAR(80),
  price         DECIMAL(10,2),
  topic         VARCHAR(80),
  publish_date  DATE
);

CREATE TABLE book_store (
  id           BIGINT IDENTITY PRIMARY KEY,
  name         VARCHAR(80),
  address      VARCHAR(80)
);

CREATE TABLE user (
  id            BIGINT IDENTITY PRIMARY KEY,
  username      VARCHAR(80),
  password      VARCHAR(80)
);