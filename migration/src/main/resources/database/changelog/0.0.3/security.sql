CREATE SEQUENCE IF NOT EXISTS member_seq START 1;
CREATE TABLE IF NOT EXISTS member
(
    id       BIGINT PRIMARY KEY DEFAULT NEXTVAL('member_seq'),
    username VARCHAR(64)  NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS role_seq START 1;
CREATE TABLE IF NOT EXISTS role
(
    id        BIGINT PRIMARY KEY DEFAULT NEXTVAL('role_seq'),
    authority VARCHAR(64) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS member_role
(
    member_id BIGINT NOT NULL,
    role_id   BIGINT NOT NULL,
    PRIMARY KEY (member_id, role_id),
    FOREIGN KEY (member_id) REFERENCES member (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);