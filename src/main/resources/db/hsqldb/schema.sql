DROP TABLE book IF EXISTS;

CREATE TABLE book (
  id           BIGINT(20) IDENTITY PRIMARY KEY,
  name         VARCHAR(80),
  author       VARCHAR(80),
  price        DECIMAL(10,2),
  topic        VARCHAR(80),
  publish_date DATE
);