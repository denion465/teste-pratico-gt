package com.daniel.backend.entity;

import com.daniel.backend.util.ConfigUrl;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@Table(schema = ConfigUrl.SCHEMA_CLINICA_MEDICA, name = "roles")
public class RolesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Collection<UserEntity> users = new HashSet<>();

  @ManyToMany
  @JoinTable(name = "roles_authorities",
    joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
  private Collection<AuthorityEntity> authorities = new HashSet<>();
}
