CREATE TABLE user
(
    id               BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name       VARCHAR(100) NOT NULL,
    last_name        VARCHAR(100) NOT NULL,
    phone_number     VARCHAR(50)  NOT NULL,
    email            VARCHAR(200) NOT NULL,
    roles            VARCHAR(100) NOT NULL,
    created_at       timestamp(6) DEFAULT CURRENT_TIMESTAMP(6),
    updated_at       timestamp(6) DEFAULT CURRENT_TIMESTAMP(6)
);