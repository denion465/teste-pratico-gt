package com.daniel.backend.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(schema = "clinica_medica", name = "users")
public class UserEntity {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  @SequenceGenerator(name = "user_id_seq", sequenceName = "clinica_medica.user_id_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false)
  private String publicId;

  @Email
  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false)
  private String encryptedPassword;

  @Column(nullable = false)
  private LocalDateTime registrationDate;

  @ManyToMany(cascade = { CascadeType.PERSIST }, fetch = FetchType.EAGER)
  @JoinTable(schema = "clinica_medica", name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
  private Collection<RoleEntity> roles = new HashSet<>();

  @OneToOne(mappedBy = "userEntity", cascade = { CascadeType.ALL })
  private PersonEnitty personEnitty;
}
