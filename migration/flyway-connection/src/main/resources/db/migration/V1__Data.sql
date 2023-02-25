CREATE TABLE users
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(15)  NOT NULL,
    first_name VARCHAR(20)  NOT NULL,
    last_name VARCHAR(20)  NOT NULL,
    email VARCHAR(40)  NOT NULL,
    status VARCHAR(25)  NOT NULL,
    password VARCHAR(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(15) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_roles
(
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL
);

ALTER TABLE user_roles
    ADD CONSTRAINT user_role_user_fk
        FOREIGN KEY (user_id) REFERENCES users (id);

ALTER TABLE user_roles
    ADD CONSTRAINT user_role_role_fk
        FOREIGN KEY (role_id) REFERENCES roles (id);

INSERT INTO users(username, first_name, last_name, email, status, password)
VALUES ('admin', 'Matvey', 'Androsyuk', 'matveyhf@gmail.com', 'ACTIVE',
        '$2a$04$qirUI5EkcMlapfYwxRO4.e/sLrSHVyuG4smLOnpYd2F3RHPnTDl9K'),
       ('user', 'Ivan', 'Shostak', 'ivanhf@gmail.com', 'ACTIVE',
        '$2a$04$J2I8127bziPA2z1MmcFcCum7KmnZ1R56/oRI00ILyI2JIfRftwSlC');

INSERT INTO roles(name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 1),
       (1, 2),
       (2, 1);