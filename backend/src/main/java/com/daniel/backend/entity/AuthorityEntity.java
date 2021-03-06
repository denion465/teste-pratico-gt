package com.daniel.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "clinica_medica", name = "authorities")
public class AuthorityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_id_seq")
  @SequenceGenerator(name = "authority_id_seq", sequenceName = "clinica_medica.authority_id_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @ManyToMany(mappedBy = "authorities")
  private Collection<RoleEntity> roles = new HashSet<>();

  public AuthorityEntity(String name) {
    this.name = name;
  }
}
