create schema clinica_medica;
create sequence clinica_medica.user_id_seq;
create sequence clinica_medica.person_id_seq;
create sequence clinica_medica.address_id_seq;

create table clinica_medica.users (
  id bigint not null default nextval('clinica_medica.user_id_seq'::regclass),
  public_id varchar(100) not null,
  email varchar(100) not null,
  encrypted_password varchar(255) not null,
  registration_date timestamp not null,

  constraint pk_users primary key (id)
);

create table clinica_medica.persons(
  id bigint not null default nextval('clinica_medica.person_id_seq'::regclass),
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  cpf varchar(15) not null,
  phone varchar(15) not null,
  birth_date date not null,
  weight varchar(10) not null,
  height varchar(10) not null,
  id_user bigint not null,
  id_address bigint not null,

  constraint pk_persons primary key (id)
);

create table clinica_medica.addresses(
  id bigint not null default nextval('clinica_medica.address_id_seq'::regclass),
  city varchar(20) not null,
  uf varchar(2) not null,
  street_name varchar(100) not null,
  postal_code varchar(8) not null,

  constraint pk_addresses primary key (id)
);

alter table clinica_medica.persons add constraint fk_id_user
  foreign key (id_user) references clinica_medica.users (id);

alter table clinica_medica.persons add constraint fk_address
  foreign key (id_address) references clinica_medica.addresses (id);
