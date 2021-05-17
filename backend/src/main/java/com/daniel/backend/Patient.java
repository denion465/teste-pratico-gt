package com.daniel.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
  @Id
  @GeneratedValue
  private Long id;

  private String Name;
  private String Cpf;
  private String Birth;
  private String Weight;
  private String Height;
  private String Uf;
}
