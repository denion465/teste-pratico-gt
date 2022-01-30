package com.daniel.backend.entity;

import com.daniel.backend.util.ConfigUrl;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_CLINICA_MEDICA, name = "users")
public class UserEntity {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  @SequenceGenerator(name = "user_id_seq", sequenceName = ConfigUrl.SCHEMA_CLINICA_MEDICA +
    ".user_id_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false)
  private String publicId;

  @NotBlank
  @Column(nullable = false, length = 50)
  private String firstName;

  @NotBlank
  @Column(nullable = false, length = 50)
  private String lastName;

  @Email
  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false)
  private String encryptedPassword;

  @NotBlank
  @Column(nullable = false)
  private String phone;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

  @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<RolesEntity> roles = new HashSet<>();
}
