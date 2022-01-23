create table users
(
    id          bigserial,
    telegram_id bigint      not null,
    nickname    varchar,
    balance     bigint      not null,
    created_at  timestamp   not null,
    first_name  varchar,
    last_name   varchar,
    payment_id  varchar(64) not null,
    role        varchar(10) not null
);

create unique index users_payment_id_uindex on users (payment_id);
create unique index users_telegram_id_uindex on users (telegram_id);
create unique index users_nickname_uindex on users (nickname);
