-- SCRIPT VERSION 1.0

CREATE TABLE people (
    id INTEGER NOT NULL IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sex VARCHAR(15),
    email VARCHAR(100),
    birthday DATE NOT NULL,
    naturalness VARCHAR(60),
    nationality VARCHAR(60),
    cpf VARCHAR(20) NOT NULL CONSTRAINT cpf_ck UNIQUE,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP NOT NULL
);

CREATE TABLE address (
    id INTEGER NOT NULL IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    people_id INTEGER NOT NULL,
    country VARCHAR(100) NOT NULL,
    state VARCHAR(30) NOT NULL,
    city VARCHAR(100) NOT NULL,
    neighborhood VARCHAR(100) NOT NULL,
    street VARCHAR(100) NOT NULL,
    numbers INTEGER NOT NULL,
    complement VARCHAR(100),
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP NOT NULL,
    FOREIGN KEY (people_id) REFERENCES people (id)
);
