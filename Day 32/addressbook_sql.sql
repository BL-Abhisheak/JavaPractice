#UC1
CREATE DATABASE address_book_db;

#UC2
CREATE TABLE address_book (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    zip INT,
    phone_number BIGINT,
    email VARCHAR(100)
);

#UC3
INSERT INTO address_book (
first_name, last_name, address, city,
state, zip, phone_number, email
) VALUES (
'Itachi', 'Akatsuki', 'SP Kovil', 'Chengalpattu',
'TN', 600021, 1234567890, 'itachi@gmail.com'
);

#UC4
UPDATE address_book
SET first_name = 'Itachi'
WHERE last_name = 'Uchicha';

#UC5
DELETE FROM address_book
WHERE first_name = 'Itachi';

#UC6
SELECT * FROM address_book
WHERE city = 'Konoha Village'
or state = 'AnimeVerse';

#UC7
SELECT COUNT(id) FROM address_book;

#UC8
SELECT * FROM address_book
SORT BY first_name ASC;

#UC9
ALTER TABLE address_book
ADD column address_book_name VARCHAR(50),
ADD column address_book_type VARCHAR(50);

#UC10
SELECT COUNT(address_book_type) FROM address_book;
