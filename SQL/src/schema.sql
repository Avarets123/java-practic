create table client (
    id serial primary key ,
    first_name char(20) not null ,
    surname char(20) not null ,
    age integer not null check (age >= 0),
    experience integer check (experience < age) ,
    driver_license bool ,
    category_license char(5) ,
    rating integer check (rating > 0 and rating <= 5)
);

alter table client add column phone_number char(12) not null ;

create table car (
    id serial primary key ,
    model char(30) not null ,
    color char(20) not null ,
    client_id serial,
    foreign key (client_id) references client(id)
);
alter table car add column number char(20) not null ;


create table trip (
    car_id serial not null ,
    client_id serial not null ,
    trip_data timestamp ,
    trip_duration time ,
    foreign key (car_id) references car(id),
    foreign key (client_id) references client(id)
);
