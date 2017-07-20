-- liquibase formatted sql

-- changeset action:create_table_books
ALTER TABLE book DROP description;
ALTER TABLE book ADD description VARCHAR(2000); 

