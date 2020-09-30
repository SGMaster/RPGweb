CREATE sequence sq_user;

create table tb_user_user(
    id_user bigint NOT NULL,
    st_user_name varchar(240) NOT NULL,
    st_user_nickname varchar(50) NOT NULL,
    st_user_password varchar(250) NOT NULL,
    st_user_email varchar(250) NOT NULL,
    CONSTRAINT  tb_user_pkey PRIMARY KEY (id_user)
);
