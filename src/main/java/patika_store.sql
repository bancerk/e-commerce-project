CREATE TABLE category
(
    id          SERIAL PRIMARY KEY,
    name        varchar(255) NOT NULL,
    createddate DATE DEFAULT CURRENT_DATE,
    updateddate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE product
(
    id          SERIAL PRIMARY KEY,
    name        varchar(255) NOT NULL,
    price       NUMERIC(10, 2),
    stock       INT,
    category_id INT REFERENCES category (id),
    createddate DATE DEFAULT CURRENT_DATE,
    updateddate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE customer
(
    id          SERIAL PRIMARY KEY,
    name        varchar(255) NOT NULL,
    email       varchar(255) NOT NULL,
    password    varchar(255) NOT NULL,
    createddate DATE DEFAULT CURRENT_DATE,
    updateddate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE "order"
(
    id                 SERIAL PRIMARY KEY,
    customer_id        INT REFERENCES customer (id),
    order_date         TIMESTAMP,
    order_total_amount NUMERIC(10, 2),
    createddate        DATE DEFAULT CURRENT_DATE,
    updateddate        DATE DEFAULT CURRENT_DATE
);

CREATE TABLE payment
(
    id             SERIAL PRIMARY KEY,
    order_id       INT REFERENCES "order" (id),
    payment_method VARCHAR(50),
    payment_amount NUMERIC(10, 2) NOT NULL,
    createddate    DATE DEFAULT CURRENT_DATE,
    updateddate    DATE DEFAULT CURRENT_DATE
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY unique not null,
    username varchar(100)              not null,
    password varchar(200)              not null,
    role     varchar(100)              not null,
    active   boolean default true
);