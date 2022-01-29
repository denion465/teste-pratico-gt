package com.daniel.backend.entity;

import com.daniel.backend.util.ConfigUrl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = ConfigUrl.SCHEMA_CLINICA_MEDICA, name = "Usuarios")
public class UserEntity {

  @Id
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
  @SequenceGenerator(name = "user_id_seq", sequenceName = ConfigUrl.SCHEMA_CLINICA_MEDICA +
    ".user_id_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false)
  private String publicId = UUID.randomUUID().toString();

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

  @CreationTimestamp
  @Column(nullable = false, columnDefinition = "datetime")
  private LocalDateTime registrationDate;
}
