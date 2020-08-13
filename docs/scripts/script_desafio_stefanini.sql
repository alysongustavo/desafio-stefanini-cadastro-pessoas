-- SCRIPT VERSION 1.0

CREATE SEQUENCE seq_user_id
    START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_role_id
    START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_people_id
    START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE seq_address_id
    START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
    id INTEGER NOT NULL CONSTRAINT user_pk PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL,
    passwords VARCHAR2(255) NOT NULL,
    status VARCHAR2(10) NOT NULL,
    CONSTRAINT email_ck UNIQUE (email)
);

CREATE TABLE role(
    id INTEGER CONSTRAINT role_pk PRIMARY KEY,
    name VARCHAR2(100) NOT NULL CONSTRAINT name_ck UNIQUE
);

CREATE TABLE user_role(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY(user_id) REFERENCES users (id),
    FOREIGN KEY(role_id) REFERENCES role (id)
);

CREATE TABLE people (
    id INTEGER NOT NULL CONSTRAINT people_pk PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    sex VARCHAR2(100) NOT NULL CONSTRAINT sex_ck UNIQUE,
    email VARCHAR2(255) NOT NULL,
    birthday DATE NOT NULL,
    naturalness VARCHAR2(100) NOT NULL,
    nationality VARCHAR2(100) NOT NULL,
    cpf VARCHAR2(100) NOT NULL
);

CREATE TABLE address (
    id INTEGER NOT NULL CONSTRAINT address_pk PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    people_id INTEGER NOT NULL,
    country VARCHAR2(100) NOT NULL,
    state VARCHAR2(30) NOT NULL,
    city VARCHAR2(100) NOT NULL,
    neighborhood VARCHAR2(100) NOT NULL,
    street VARCHAR2(100) NOT NULL,
    numbers INTEGER NOT NULL,
    complement VARCHAR2(100),
    FOREIGN KEY (people_id) REFERENCES people (id)
);

CREATE OR REPLACE TRIGGER trigger_autoincrement_user
  BEFORE INSERT ON users
  FOR EACH ROW
BEGIN
  SELECT seq_user_id.nextval
    INTO :new.id
    FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_autoincrement_role
  BEFORE INSERT ON role
  FOR EACH ROW
BEGIN
  SELECT seq_role_id.nextval
    INTO :new.id
    FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_autoincrement_people
  BEFORE INSERT ON people
  FOR EACH ROW
BEGIN
  SELECT seq_people_id.nextval
    INTO :new.id
    FROM dual;
END;

CREATE OR REPLACE TRIGGER trigger_autoincrement_address
  BEFORE INSERT ON address
  FOR EACH ROW
BEGIN
  SELECT seq_address_id.nextval
    INTO :new.id
    FROM dual;
END;
