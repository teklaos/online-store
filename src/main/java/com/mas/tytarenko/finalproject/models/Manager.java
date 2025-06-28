package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Manager extends Employee {

  @NotBlank(message = "Degree is required.")
  private String degree;

  @NotBlank(message = "Certificate ID is required.")
  @Column(unique = true)
  private String certificateId;

  @OneToOne(mappedBy = "manager")
  private Warehouse warehouse;
}
