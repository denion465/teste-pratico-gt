create sequence authority_id_seq;
create sequence role_id_seq;

create table roles(
  id bigint not null default nextval('role_id_seq'::regclass),
  name varchar(50) not null,

  constraint pk_roles primary key (id)
);

create table authorities(
  id bigint not null default nextval('authority_id_seq'::regclass),
  name varchar(50) not null,

  constraint pk_authorities primary key (id)
);

create table users_roles(
  user_id bigint not null,
  role_id bigint not null
);

create table roles_authorities(
  role_id bigint not null,
  authority_id bigint not null
);

-- Foreing keys table users_roles
alter table users_roles add constraint fk_user_id
  foreign key (user_id) references users (id);

alter table users_roles add constraint fk_role_id
  foreign key (role_id) references roles (id);

-- Foreing keys table roles_authorities
alter table roles_authorities add constraint fk_role_id
  foreign key (role_id) references roles (id);

alter table roles_authorities add constraint fk_authority_id
  foreign key (authority_id) references authorities (id);


