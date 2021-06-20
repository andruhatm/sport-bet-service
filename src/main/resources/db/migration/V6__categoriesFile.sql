create table if not exists categories_file
(
    categories_file_id   serial primary key,
    categories_file_name varchar(100) not null
);


ALTER TABLE media
    ADD
        categories_file_categories_file_id INTEGER REFERENCES categories_file (categories_file_id);
