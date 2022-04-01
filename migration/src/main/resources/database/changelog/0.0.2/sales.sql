CREATE SEQUENCE IF NOT EXISTS sale_seq START 1;
CREATE TABLE IF NOT EXISTS sale
(
    id         BIGINT PRIMARY KEY DEFAULT NEXTVAL('sale_seq'),
    timestamp  TIMESTAMP        NOT NULL,
    sum        FLOAT            NOT NULL,
    quantity   DOUBLE PRECISION NOT NULL,
    product_id BIGINT           NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE
);