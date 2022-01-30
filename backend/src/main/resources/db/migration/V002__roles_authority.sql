create table clinica_medica.roles(
  id bigint not null,
  name varchar(50) not null,

  constraint pk_roles primary key (id)
);

create table clinica_medica.users_roles(
  user_id bigint not null,
  role_id bigint not null
);

create table clinica_medica.authorities(
  id bigint not null,
  name varchar(50) not null,

  constraint pk_authorities primary key (id)
);

create table clinica_medica.roles_authorities(
  role_id bigint not null,
  authority_id bigint not null
);

-- Foreing keys table users_roles
alter table clinica_medica.users_roles add constraint fk_user_id
  foreign key (user_id) references clinica_medica.users (id);

alter table clinica_medica.users_roles add constraint fk_role_id
  foreign key (role_id) references clinica_medica.roles (id);

-- Foreing keys table roles_authorities
alter table clinica_medica.roles_authorities add constraint fk_role_id
  foreign key (role_id) references clinica_medica.roles (id);

alter table clinica_medica.roles_authorities add constraint fk_authority_id
  foreign key (authority_id) references clinica_medica.authorities (id);


