
-- Inserting data into the User table
INSERT INTO users (first_name, last_name, email, phone, member_type, address_id) VALUES ('Erik', 'Johansson', 'erik.johansson@example.com', '0701234567', 'Premium', 1);
INSERT INTO users (first_name, last_name, email, phone, member_type, address_id) VALUES ('Anna', 'Karlsson', 'anna.karlsson@example.com', '0702345678', 'Standard', 2);
INSERT INTO users (first_name, last_name, email, phone, member_type, address_id) VALUES ('Lars', 'Andersson', 'lars.andersson@example.com', '0703456789', 'Premium', 3);
INSERT INTO users (first_name, last_name, email, phone, member_type, address_id) VALUES ('Emma', 'Nilsson', 'emma.nilsson@example.com', '0704567890', 'Standard', 4);
INSERT INTO users (first_name, last_name, email, phone, member_type, address_id) VALUES ('Karl', 'Gustavsson', 'karl.gustavsson@example.com', '0705678901', 'Premium', 5);



-- Inserting data into the Address table
INSERT INTO addresses (street, city, zip_code, country) VALUES ('Storgatan 1', 'Stockholm', '111 22', 'Sweden');
INSERT INTO addresses (street, city, zip_code, country) VALUES ('Lillgatan 2', 'Stockholm', '222 33', 'Sweden');
INSERT INTO addresses (street, city, zip_code, country) VALUES ('Mellangatan 3', 'Stockholm', '333 44', 'Sweden');
INSERT INTO addresses (street, city, zip_code, country) VALUES ('Storgatan 4', 'Stockholm', '444 55', 'Sweden');
INSERT INTO addresses (street, city, zip_code, country) VALUES ('Lillgatan 5', 'Stockholm', '555 66', 'Sweden');



-- Inserting data int the post table
INSERT INTO posts (title, content, author_id) VALUES ('Post 1', 'This is the first post', 1);
INSERT INTO posts (title, content, author_id) VALUES ('Post 2', 'This is the second post', 2);
INSERT INTO posts (title, content, author_id) VALUES ('Post 3', 'This is the third post', 3);
INSERT INTO posts (title, content, author_id) VALUES ('Post 4', 'This is the fourth post', 4);
INSERT INTO posts (title, content, author_id) VALUES ('Post 5', 'This is the fifth post', 5);