create table repaired_cars
(
    id       serial      not null
        constraint products_pkey
            primary key,
    brand     varchar(50) not null,
    color     varchar(50) not null,
    repairTime int not null ,
    deliverTime int not null
);

alter table repaired_cars
    owner to postgres;
