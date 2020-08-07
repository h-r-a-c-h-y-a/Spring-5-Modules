CREATE TABLE SINGER (
    id serial,
    first_name varchar(60) not null ,
    last_name varchar(40) not null ,
    birth_date date ,
    unique (first_name, last_name)
);

CREATE TABLE ALBUM (
    id serial ,
    singer_id bigint not null ,
    title varchar(100) not null ,
    release_date date ,
    unique (singer_id, title) ,
    foreign key (singer_id) references SINGER(id)
);