create table if not exists media
(
    media_id   integer primary key,
    file_name  varchar(100) not null unique,
    client_id  integer REFERENCES clients (client_id) on delete cascade,
    width int,
    height int,
    security_url varchar(255)
);
