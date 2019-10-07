CREATE SCHEMA IF NOT EXISTS game_store;
USE game_store;


CREATE TABLE IF NOT EXISTS users(
username VARCHAR(50) NOT NULL PRIMARY KEY,
password VARCHAR(100) NOT NULL,
enabled BOOLEAN NOT NULL);

CREATE TABLE IF NOT EXISTS authorities(
username VARCHAR(50) NOT NULL,
authority VARCHAR(50) NOT NULL,
CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username));

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);



INSERT INTO users (username, password, enabled) VALUES 
("admin", "$2a$10$OaBVdfZXedWrtsFx1NtieeTaZezoURjM8sLpQAt6xoKT6XpBMcmvO", true),
("manager", "$2a$10$AX2oHBuRiYPfvz.fEiQN1ez2cd7qHQTa8YYWs.bbPn3pKyYUZSrpW", true),
 ("staff", "$2a$10$e/iGR6EIpoEq2BoJFs24iu2kH9MDlF30rkrLBAKpCiEcRQoMWt4Su", true);

INSERT INTO authorities (username, authority) values
("admin", "ROLE_STAFF"),
("admin", "ROLE_MANAGER"),
("admin", "ROLE_ADMIN"),
("manager", "ROLE_MANAGER"),
("manager", "ROLE_STAFF"),
("staff", "ROLE_STAFF");

create table if not exists game (
    game_id int(11) not null auto_increment primary key,
    title varchar(50) not null,
    esrb_rating varchar(50) not null,
    description varchar(255) not null,
    price decimal(5, 2) not null,
    studio varchar(50) not null,
    quantity int(11)
);

create table if not exists console (
    console_id int(11) not null auto_increment primary key,
    model varchar(50) not null,
    manufacturer varchar(50) not null,
    memory_amount varchar(20),
    processor varchar(20),
    price decimal(5, 2) not null,
    quantity int(11) not null
);

create table if not exists t_shirt (
    t_shirt_id int(11) not null auto_increment primary key,
    size varchar(20) not null,
    color varchar(20) not null,
    description varchar(255) not null,
    price decimal(5,2) not null,
    quantity int(11) not null
);

create table if not exists sales_tax_rate (
    state char(2) not null,
    rate decimal(3,2) not null
);

create unique index ix_state_rate on sales_tax_rate (state, rate);

create table if not exists processing_fee (
    product_type varchar(20) not null,
    fee decimal (4,2)
);

create unique index ix_product_type_fee on processing_fee (product_type, fee);

create table if not exists invoice (
    invoice_id int(11) not null auto_increment primary key,
    name varchar(80) not null,
    street varchar(30) not null,
    city varchar(30) not null,
    state varchar(30) not null,
    zipcode varchar(5) not null,
    item_type varchar(20) not null,
    item_id int(11) not null,
    unit_price decimal(5,2) not null,
    quantity int(11) not null,
    subtotal decimal(5,2) not null,
    tax decimal(5,2) not null,
    processing_fee decimal (5,2) not null,
    total decimal(5,2) not null
);
INSERT into sales_tax_rate (state, rate) VALUES
("AL", .05),
("AK", .06),
("AZ", .04),
("AR", .06),
("CA", .06),
("CO", .04),
("CT", .03),
("DE", .05),
("FL", .06),
("GA", .07),
("HI", .05),
("ID", .03),
("IL", .05),
("IN", .05),
("IA", .04),
("KS", .06),
("KY", .04),
("LA", .05),
("ME", .03),
("MD", .07),
("MA", .05),
("MI", .06),
("MN", .06),
("MS", .05),
("MO", .05),
("MT", .03),
("NE", .04),
("NV", .04),
("NH", .06),
("NJ", .05),
("NY", .06),
("NC", .05),
("ND", .05), 
("OH", .04),
("OK", .04),
("OR", .07),
("PA", .06),
("RI", .06),
("SC", .06),
("SD", .06),
("TN", .05),
("TX", .03),
("UT", .04),
("VT", .07),
("VA", .06),
("WA", .05), 
("WV", .05),
("WI", .03),
("WY", .04);


INSERT into processing_fee (product_type, fee) VALUES
("Consoles", 14.99),
("T-Shirts", 1.98),
("Games", 1.49);
