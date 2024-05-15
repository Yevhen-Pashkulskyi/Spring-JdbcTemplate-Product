CREATE
DATABASE demo_db;

CREATE TABLE IF NOT EXISTS product
( id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    quota INTEGER(56) NOT NULL,
    price DECIMAL (20,2) NOT NULL,
    PRIMARY KEY (id)
    );