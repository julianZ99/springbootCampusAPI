DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS privileges;

CREATE TABLE IF NOT EXISTS role_privileges (
    id bigint(20) AUTO_INCREMENT PRIMARY KEY,
    role_id bigint(20),
    privilege_id bigint(20),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (privilege_id) REFERENCES privileges(id)
);

INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('STAFF');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO privileges (name) VALUES ('READ');
INSERT INTO privileges (name) VALUES ('WRITE');
INSERT INTO privileges (name) VALUES ('UPLOAD');

INSERT INTO role_privileges (role_id, privilege_id) VALUES (1, 1);
INSERT INTO role_privileges (role_id, privilege_id) VALUES (1, 2);

INSERT INTO role_privileges (role_id, privilege_id) VALUES (2, 3);