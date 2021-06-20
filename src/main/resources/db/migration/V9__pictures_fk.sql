alter table clients
add picture_id INTEGER references pictures(picture_id);
