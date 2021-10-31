CREATE TABLE user
(
    id                     BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name                   varchar(255) NOT NULL,
    gender                 varchar(255) NOT NULL,
    age                    int(11),
    created_at             datetime     NOT NULL,
    updated_at             datetime     NOT NULL
);
