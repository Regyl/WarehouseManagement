CREATE SEQUENCE nomenclature_seq START 1;
CREATE TABLE IF NOT EXISTS nomenclature
(
    id BIGINT PRIMARY KEY DEFAULT NEXTVAL('nomenclature_seq'),

)