CREATE TABLE books (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    price INTEGER DEFAULT 0,
    yearOfPublication INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE genres (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authors (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    firstName VARCHAR(128) NOT NULL,
    secondName VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_authors_relations (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    book_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_genres_relations (
    id   INTEGER      NOT NULL AUTO_INCREMENT,
    book_id INTEGER NOT NULL,
    genre_id INTEGER NOT NULL,
    PRIMARY KEY (id)
);