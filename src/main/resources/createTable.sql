CREATE TABLE IF NOT EXISTS REQUEST (
    id BIGINT AUTO_INCREMENT,
    clientId VARCHAR(6),
    requestId BIGINT,
    name VARCHAR (255),
    quantity INTEGER,
    price DECIMAL
);