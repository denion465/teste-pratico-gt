create schema clinica_medica;
create sequence clinica_medica.user_id_seq;

create table clinica_medica.usuarios (
  id bigint not null default nextval('clinica_medica.user_id_seq'::regclass),
  public_id varchar(100) not null,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  email varchar(100) not null,
  encrypted_password varchar(255) not null,
  phone_number varchar(20) not null,

  constraint pk_usuarios primary key (id)
);

