CREATE TABLE IF NOT EXISTS garage
(
    id       SERIAL PRIMARY KEY,
    city     VARCHAR(255) NOT NULL,
    street   VARCHAR(255) NOT NULL,
    building VARCHAR(255) NOT NULL,
    capacity INT          NOT NULL,
    name     VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS car
(
    id             SERIAL PRIMARY KEY,
    vin_code       VARCHAR(128) UNIQUE        NOT NULL,
    brand          VARCHAR(128)               NOT NULL,
    model          VARCHAR(128)               NOT NULL,
    year_issue     INT                        NOT NULL,
    colour         VARCHAR(128)               NOT NULL,
    seats_quantity INT                        NOT NULL,
    garage_id      INT REFERENCES garage (id) NOT NULL
);