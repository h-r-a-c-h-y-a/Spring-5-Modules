create table singer(
    id bigserial PRIMARY KEY ,
    first_name varchar(60) not null ,
    last_name varchar(40) not null ,
    birth_date date ,
    description varchar(2000) ,
    photo bytea ,
    version int not null default 0 ,
    unique (first_name, last_name)
);