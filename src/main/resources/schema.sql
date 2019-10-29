CREATE TABLE books (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    price INTEGER DEFAULT 0,
    year_of_publication INTEGER,
    PRIMARY KEY (id)
);

CREATE TABLE genres (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE authors (
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(128) NOT NULL,
    second_name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_authors_relations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE books_genres_relations (
    id BIGINT NOT NULL AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);