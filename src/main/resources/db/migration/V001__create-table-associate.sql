create table public.associate (
    id uuid not null,
    created_at timestamp with time zone,
    document varchar(40),
    name varchar(255),
    status varchar(255),
    primary key (id),
    constraint uk_document unique (document)
);