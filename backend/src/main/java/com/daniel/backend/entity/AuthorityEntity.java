package com.daniel.backend.entity;

import com.daniel.backend.util.ConfigUrl;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Data
@Entity
@Table(schema = ConfigUrl.SCHEMA_CLINICA_MEDICA, name = "authorities")
public class AuthorityEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(nullable = false, length = 50)
  private String name;

  @ManyToMany(mappedBy = "authorities")
  private Collection<RolesEntity> roles = new HashSet<>();
}
