-- create database musicdb;

create table singer
(
    id         serial PRIMARY KEY,
    first_name varchar(60) not null,
    last_name  varchar(40) not null,
    birth_date date,
    version    int         not null default 0,
    unique (first_name, last_name)
);

create table album
(
    id           serial PRIMARY KEY,
    singer_id    bigint       not null,
    title        varchar(100) not null,
    release_date date,
    version      int          not null default 0,
    unique (singer_id, title),
    foreign key (singer_id) references singer (id)
);

create table instrument
(
    id varchar(20) PRIMARY KEY
);

create table singer_instrument
(
    singer_id     bigint not null,
    instrument_id varchar(20) not null,
    foreign key (singer_id) references singer (id),
    foreign key (instrument_id) references instrument (id)
);