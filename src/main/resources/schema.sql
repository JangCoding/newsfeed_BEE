drop table if exists feed cascade;
create table feed
(
    id                bigint generated by default as identity,
    user_id           bigint not null,
    deleted_date_time timestamp with time zone,
    store_name        varchar(50) not null,
    category          varchar(50) not null,
    address           varchar(200) not null,
    score             int not null,
    visited_date_time timestamp with time zone not null,
    waited            boolean not null,
    store_size         int not null,
    content           varchar(1023) not null,
    primary key (id)
);
