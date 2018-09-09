drop table if exists modification;
drop table if exists connection_category;
drop table if exists connection_type;
drop table if exists status;
drop table if exists municipality;
drop table if exists connection_purpose;
drop table if exists unit;
drop table if exists profile;
drop table if exists request_type;
drop table if exists person;
drop table if exists user;
drop table if exists user_role;
drop table if exists connection_request_form;
drop table if exists work_order;
drop table if exists equipment_materials;
drop table if exists contract;
drop table if exists connection;
drop table if exists connection_history;

CREATE TABLE modification (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE connection_category (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE request_purpose (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE status (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE municipality (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE connection_purpose (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE unit (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE profile (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
description VARCHAR(100)
);

CREATE TABLE request_type (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR(30) NOT NULL,
description VARCHAR(100) 
);

CREATE TABLE person (
id INT(11) IDENTITY PRIMARY KEY,
name VARCHAR(50) NOT NULL,
surname_nickname VARCHAR(50) NOT NULL,
oib VARCHAR(11) NOT NULL,
address VARCHAR(100) NOT NULL,
phone VARCHAR (30) NOT NULL,
email VARCHAR (50) NOT NULL
);

CREATE TABLE user (
id INT (11) IDENTITY PRIMARY KEY,
name VARCHAR (50) NOT NULL,
surname VARCHAR (50) NOT NULL,
username VARCHAR (50) NOT NULL,
password VARCHAR (50) NOT NULL,
enabled TINYINT NOT NULL DEFAULT 1
);

CREATE TABLE user_role (
id INT (11) IDENTITY PRIMARY KEY,
user_id INT(11) NOT NULL,
role varchar(45) NOT NULL,
FOREIGN KEY (user_id) REFERENCES USER (id)
);

CREATE TABLE connection_request_form (
id INT(11) IDENTITY PRIMARY KEY,
submission_date DATE,
submitter INT (11) NOT NULL,
request_type INT (11),
request_purpose INT (11),
author INT (11),
FOREIGN KEY (submitter) REFERENCES person (id),
FOREIGN KEY (request_type) REFERENCES request_type (id),
FOREIGN KEY (request_purpose) REFERENCES request_purpose (id),
FOREIGN KEY (author) REFERENCES user (id)
);

CREATE TABLE work_order (
id INT(11) IDENTITY PRIMARY KEY,
work_order_no VARCHAR (30) NOT NULL,
working_hours INT (30),
work_type VARCHAR (50),
);

CREATE TABLE equipment_materials (
id INT(11) IDENTITY PRIMARY KEY,
work_order_id INT(11) NOT NULL,
name VARCHAR (50) NOT NULL,
unit INT (11) NOT NULL,
quantity INT (11) NOT NULL,
profile INT (11) NOT NULL,
FOREIGN KEY (unit) REFERENCES unit (id),
FOREIGN KEY (profile) REFERENCES profile (id)
);

CREATE TABLE contract (
id INT(11) IDENTITY PRIMARY KEY,
signing_date DATE NOT NULL,
contractor INT(11) NOT NULL, 
responsible_person VARCHAR (30) NOT NULL,
author INT(11) NOT NULL,
FOREIGN KEY (contractor) REFERENCES person (id),
FOREIGN KEY (author) REFERENCES user (id)
);

CREATE TABLE connection (
id INT(11) IDENTITY PRIMARY KEY,
request_form_id INT (11),
contract_id INT (11),
connection_category INT (11),
connection_date DATE,
work_order_id INT(11),
registry_book_no VARCHAR (30) NOT NULL,
owner INT (11),
status INT (11),
cadastral_parcel_no VARCHAR (30) NOT NULL,
cadastral_municipality INT (11) NOT NULL,
settlement_area VARCHAR (50) NOT NULL,
address VARCHAR (100) NOT NULL,
connection_purpose INT (11) NOT NULL,
has_drainage BOOLEAN NOT NULL,
documentation VARCHAR (100),
FOREIGN KEY (request_form_id) REFERENCES connection_request_form (id),
FOREIGN KEY (contract_id) REFERENCES contract (id),
FOREIGN KEY (connection_category) REFERENCES connection_category (id),
FOREIGN KEY (owner) REFERENCES person (id),
FOREIGN KEY (status) REFERENCES status (id),
FOREIGN KEY (cadastral_municipality) REFERENCES municipality (id),
FOREIGN KEY (connection_purpose) REFERENCES connection_purpose (id),
FOREIGN KEY (work_order_id) REFERENCES work_order (id),
CONSTRAINT registry_book_municipality_unique UNIQUE(registry_book_no, cadastral_municipality)
);

CREATE TABLE work_order_connection (
work_order_id INT(11),
connection_id INT(11),
FOREIGN KEY (work_order_id) REFERENCES work_order (id),
FOREIGN KEY (connection_id) REFERENCES connection (id)
);

CREATE TABLE connection_history (
id INT(11) IDENTITY PRIMARY KEY,
connection_id INT(11) NOT NULL,
modification_id INT(11) NOT NULL,
date DATE NOT NULL,
author INT(11) NOT NULL,
work_order_id INT(11) NOT NULL,
current_owner INT(11) NOT NULL,
current_registry_book_no VARCHAR (30) NOT NULL,
FOREIGN KEY (connection_id) REFERENCES connection (id),
FOREIGN KEY (modification_id) REFERENCES modification (id),
FOREIGN KEY (author) REFERENCES user (id),
FOREIGN KEY (work_order_id) REFERENCES work_order (id),
FOREIGN KEY (current_owner) REFERENCES work_order (id)
);




