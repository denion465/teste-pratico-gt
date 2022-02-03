package com.daniel.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "clinica_medica", name = "persons")
public class PersonEnitty {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
  @SequenceGenerator(name = "person_id_seq", sequenceName = "clinica_medica.person_id_seq", allocationSize = 1)
  private long id;

  @NotBlank
  @Column(nullable = false, length = 50)
  private String firstName;

  @NotBlank
  @Column(nullable = false, length = 50)
  private String lastName;

  @NotBlank
  @Column(nullable = false, length = 15)
  private String cpf;

  @NotBlank
  @Column(nullable = false, length = 15)
  private String phone;

  @NotBlank
  @Column(nullable = false, length = 10)
  private LocalDate birthDate;

  @NotBlank
  @Column(nullable = false, length = 10)
  private String weight;

  @NotBlank
  @Column(nullable = false, length = 10)
  private String height;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_user")
  private UserEntity userEntity;

  @OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
  @JoinColumn(name = "id_address")
  private AddressEntity addresses;
}
