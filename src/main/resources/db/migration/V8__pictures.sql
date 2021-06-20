create table if not exists pictures
(
    picture_id serial       not null
        constraint photos_pk
            primary key,
    name    varchar(255) not null,
    type    varchar(255) not null,
    data    bytea        not null
);
