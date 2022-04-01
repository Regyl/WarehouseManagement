CREATE SEQUENCE IF NOT EXISTS logging_seq START 1;
CREATE TABLE IF NOT EXISTS logging
(
    id        BIGINT PRIMARY KEY DEFAULT NEXTVAL('logging_seq'),
    full_name VARCHAR(255) NOT NULL,
    username  VARCHAR(64)  NOT NULL,
    FOREIGN KEY (username) REFERENCES member (username)
);