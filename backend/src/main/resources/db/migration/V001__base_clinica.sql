create schema clinica_medica;
create sequence clinica_medica.user_id_seq;

create table clinica_medica.usuarios (
  id bigint not null default nextval('clinica_medica.user_id_seq'::regclass),
  public_id varchar(100) not null,
  first_name varchar(50) not null,
  last_name varchar(50) not null,
  email varchar(100) not null,
  encrypted_password varchar(255) not null,
  phone varchar(20) not null,
  registration_date timestamp not null,

  constraint pk_usuarios primary key (id)
);
