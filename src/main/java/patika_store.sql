CREATE TABLE category(
id SERIAL PRIMARY KEY,
name varchar(255) NOT NULL,
creationDate DATE DEFAULT CURRENT_DATE,
updatedDate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE product(
id SERIAL PRIMARY KEY,
name varchar(255) NOT NULL,
private NUMERIC(10,2),
stock INT,
category_id INT REFERENCES category(id),
creationDate DATE DEFAULT CURRENT_DATE,
updatedDate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE customer(
id SERIAL PRIMARY KEY,
name varchar(255) NOT NULL,
email varchar(255) NOT NULL,
password varchar(255) NOT NULL,
creationDate DATE DEFAULT CURRENT_DATE,
updatedDate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE "order"(
id SERIAL PRIMARY KEY,
customer_id INT REFERENCES customer(id),
order_date TIMESTAMP,
order_total_amount NUMERIC(10,2),
creationDate DATE DEFAULT CURRENT_DATE,
updatedDate DATE DEFAULT CURRENT_DATE
);

CREATE TABLE payment(
id SERIAL PRIMARY KEY,
order_id INT REFERENCES "order"(id),
payment_method VARCHAR(50),
payment_amount NUMERIC(10,2) NOT NULL,
creationDate DATE DEFAULT CURRENT_DATE,
updatedDate DATE DEFAULT CURRENT_DATE
);