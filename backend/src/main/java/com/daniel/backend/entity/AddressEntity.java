package com.daniel.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity
@Table(schema = "clinica_medica", name = "addresses")
public class AddressEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_seq")
  @SequenceGenerator(name = "address_id_seq", sequenceName = "clinica_medica.address_id_seq", allocationSize = 1)
  private long id;

  @NotBlank
  @Column(nullable = false, length = 20)
  private String city;

  @NotBlank
  @Column(nullable = false, length = 2)
  private String uf;

  @NotBlank
  @Column(nullable = false, length = 100)
  private String streetName;

  @NotBlank
  @Column(nullable = false, length = 8)
  private String postalCode;

  @OneToOne(mappedBy = "addresses")
  private PersonEnitty personEnitty;
}
