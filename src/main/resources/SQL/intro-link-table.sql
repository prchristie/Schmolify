DROP TABLE IF EXISTS link;

CREATE TABLE link (
    id VARCHAR(16) PRIMARY KEY,
    url VARCHAR(1024) NOT NULL
);