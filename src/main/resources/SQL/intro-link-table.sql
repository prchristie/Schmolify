DROP TABLE IF EXISTS schmol;
DROP DATABASE IF EXISTS schmolify;

CREATE DATABASE schmolify;
USE schmolify;

CREATE TABLE schmol (
    id VARCHAR(16) PRIMARY KEY,
    url VARCHAR(1024) NOT NULL
);