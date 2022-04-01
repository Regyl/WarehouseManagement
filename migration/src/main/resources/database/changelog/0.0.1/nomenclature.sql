CREATE SEQUENCE IF NOT EXISTS nomenclature_seq START 1;
CREATE TABLE IF NOT EXISTS nomenclature
(
    id               BIGINT PRIMARY KEY DEFAULT NEXTVAL('nomenclature_seq'),
    name             VARCHAR(255) NOT NULL UNIQUE,
    product_type     VARCHAR(128) NOT NULL,
    frequency_type   VARCHAR(64)  NOT NULL,
    country          VARCHAR(64),
    create_timestamp TIMESTAMP    NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_seq START 1;
CREATE TABLE IF NOT EXISTS product
(
    id              BIGINT PRIMARY KEY DEFAULT NEXTVAL('PRODUCT_seq'),
    cost            FLOAT            NOT NULL,
    quantity        DOUBLE PRECISION NOT NULL,
    expires_at      DATE,
    nomenclature_id BIGINT           NOT NULL UNIQUE,
    FOREIGN KEY (nomenclature_id) REFERENCES nomenclature (id)
);