package com.register.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Street{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name="street_name", length = 100)
   @NotEmpty(message = "Informe um valor para o nome da rua.")
   private String streetName;
   @NotEmpty(message = "Informe um valor para o numero da rua.")
   private String number;
   @Column(length = 100)
   private String complement;
   @Column(length = 80)
   @NotEmpty(message = "Informe um valor para a vizinhanca.")
   private String neighbourhood;
   @Column(length = 60)
   @NotEmpty(message = "Informe um valor para a cidade.")
   private String city;
   @Column(length = 20)
   @NotEmpty(message = "Informe um valor para o estado.")
   private String state;
   @Column(length = 60)
   @NotEmpty(message = "Informe um valor para o pais.")
   private String country;
   @Column(length = 8)
   @NotEmpty(message = "Informe um valor para o cep.")
   private String zipcode;
   @Column(length = 40)
   private Double latitude;
   @Column(length = 40)
   private Double longitude;
}

