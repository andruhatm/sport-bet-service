create table if not exists events
(
    event_id  serial       not null
        constraint events_pk
            primary key,
    date      timestamp    not null,
    name      varchar(255) not null,
    home_team varchar(255) not null,
    away_team varchar(255) not null
);

create table if not exists currency
(
    currency_id   serial       not null
        constraint currency_pk
            primary key,
    currency_type varchar(255) not null,
    exchange      double precision
);

create table if not exists photos
(
    file_id serial       not null
        constraint photos_pk
            primary key,
    name    varchar(255) not null,
    type    varchar(255) not null,
    data    bytea        not null
);

create table if not exists clients
(
    client_id serial          not null
        constraint clients_pk
            primary key,
    username  varchar(255) not null,
    password  varchar(255) not null,
    active    boolean      not null,
    photo_id  integer      not null
        constraint clients_fk0
            references photos,
    balance   double precision
);

create table if not exists bets
(
    bet_id serial not null
        constraint bets_pk
            primary key,
    event_id    integer not null
        constraint bets_fk0
            references events,
    currency_id integer not null
        constraint bets_fk1
            references currency,
    client_id   integer not null
        constraint bets_fk2
            references clients,
    amount      double precision,
    prediction  varchar(255),
    winner      varchar(255)
);

create table if not exists user_role
(
    user_id serial not null
        constraint fkrenwksoo962sqj00bg2p6qxxy
            references clients,
    roles   varchar(255)
);

