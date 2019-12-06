create table accounts
(
    id           bigint generated by default as identity
        constraint accounts_pkey
            primary key,
    address      varchar(255),
    first_name   varchar(255),
    last_name    varchar(255),
    patronymic   varchar(255),
    phone_number varchar(255),
    photo_uri    varchar(255),
    username     varchar(255)
        constraint uk_k8h1bgqoplx0rkngj01pm1rgp
            unique
);

alter table accounts
    owner to postgres;

create table authors
(
    id          bigint generated by default as identity
        constraint authors_pkey
            primary key,
    first_name  varchar(255),
    second_name varchar(255)
);

alter table authors
    owner to postgres;

create table books
(
    id                  bigint generated by default as identity
        constraint books_pkey
            primary key,
    name                varchar(255),
    picture_uri         varchar(255),
    price               double precision not null,
    year_of_publication integer          not null
);

alter table books
    owner to postgres;

create table books_authors
(
    book_id   bigint not null
        constraint fk1b933slgixbjdslgwu888m34v
            references books,
    author_id bigint not null
        constraint fk3qua08pjd1ca1fe2x5cgohuu5
            references authors,
    constraint books_authors_pkey
        primary key (book_id, author_id)
);

alter table books_authors
    owner to postgres;

create table genres
(
    id   bigint generated by default as identity
        constraint genres_pkey
            primary key,
    name varchar(255)
);

alter table genres
    owner to postgres;

create table books_genres
(
    book_id  bigint not null
        constraint fklv42b6uemg63q27om39jjbt9o
            references books,
    genre_id bigint not null
        constraint fkgkat05y2cec3tcpl6ur250sd0
            references genres,
    constraint books_genres_pkey
        primary key (book_id, genre_id)
);

alter table books_genres
    owner to postgres;

create table order_statuses
(
    id   integer generated by default as identity
        constraint order_statuses_pkey
            primary key,
    name varchar(255)
        constraint uk_p14tnvp6d460yt9akmq14bigx
            unique
);

alter table order_statuses
    owner to postgres;

create table orders
(
    id               bigint generated by default as identity
        constraint orders_pkey
            primary key,
    customer_address varchar(255),
    customer_name    varchar(255),
    customer_phone   varchar(255),
    order_date_time  timestamp,
    username         varchar(255),
    order_status_id  integer
        constraint fkcbbqf26brulgfgvd0mf74rv4y
            references order_statuses
);

alter table orders
    owner to postgres;

create table order_details
(
    id       bigint generated by default as identity
        constraint order_details_pkey
            primary key,
    quantity integer not null,
    book_id  bigint
        constraint fkjqe04yonp6a52rhbf2y0m03qw
            references books,
    order_id bigint
        constraint fkjyu2qbqt8gnvno9oe9j2s2ldk
            references orders
);

alter table order_details
    owner to postgres;

create table oauth_client_details
(
    client_id               varchar(256) not null
        constraint oauth_client_details_pkey
            primary key,
    resource_ids            varchar(256),
    client_secret           varchar(256),
    scope                   varchar(256),
    authorized_grant_types  varchar(256),
    web_server_redirect_uri varchar(256),
    authorities             varchar(256),
    access_token_validity   integer,
    refresh_token_validity  integer,
    additional_information  varchar(4096),
    autoapprove             varchar(256)
);

alter table oauth_client_details
    owner to postgres;

create table oauth_client_token
(
    token_id          varchar(256),
    token             bytea,
    authentication_id varchar(256),
    user_name         varchar(256),
    client_id         varchar(256)
);

alter table oauth_client_token
    owner to postgres;

create table oauth_access_token
(
    token_id          varchar(256),
    token             bytea,
    authentication_id varchar(256),
    user_name         varchar(256),
    client_id         varchar(256),
    authentication    bytea,
    refresh_token     varchar(256)
);

alter table oauth_access_token
    owner to postgres;

create table oauth_refresh_token
(
    token_id       varchar(256),
    token          bytea,
    authentication bytea
);

alter table oauth_refresh_token
    owner to postgres;

create table oauth_code
(
    code           varchar(256),
    authentication bytea
);

alter table oauth_code
    owner to postgres;

create table oauth_approvals
(
    userid         varchar(256),
    clientid       varchar(256),
    scope          varchar(256),
    status         varchar(10),
    expiresat      timestamp,
    lastmodifiedat timestamp
);

alter table oauth_approvals
    owner to postgres;

create table users
(
    username varchar(256) not null
        constraint users_pkey
            primary key,
    password varchar(256) not null,
    enabled  boolean      not null
);

alter table users
    owner to postgres;

create table authorities
(
    username  varchar(256) not null
        constraint fk_authorities_users
            references users,
    authority varchar(256) not null
);

alter table authorities
    owner to postgres;

create unique index ix_auth_username
    on authorities (username, authority);

