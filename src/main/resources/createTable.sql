CREATE TABLE IF NOT EXISTS request (
    id BIGINT AUTO_INCREMENT,
    client_id VARCHAR(6),
    request_id BIGINT,
    name VARCHAR (255),
    quantity INTEGER,
    price DECIMAL,
    PRIMARY KEY (id)
);