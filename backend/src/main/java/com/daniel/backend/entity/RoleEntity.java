package com.daniel.backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@Entity(name = "roles")
@Table(schema = "clinica_medica")
public class RoleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
  @SequenceGenerator(name = "role_id_seq", sequenceName = "clinica_medica.role_id_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Collection<UserEntity> users = new HashSet<>();

  @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
  @JoinTable(schema = "clinica_medica", name = "roles_authorities",
    joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
  private Collection<AuthorityEntity> authorities = new HashSet<>();

  public RoleEntity(String name) {
    this.name = name;
  }
}
