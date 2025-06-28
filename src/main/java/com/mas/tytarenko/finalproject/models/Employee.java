package com.mas.tytarenko.finalproject.models;

import com.mas.tytarenko.finalproject.models.enums.EmployeeType;
import com.mas.tytarenko.finalproject.models.enums.WorkPermitType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "First name is required.")
  @Size(min = 2, max = 255, message = "First name must be between 2 and 255 characters.")
  private String firstName;

  @NotBlank(message = "Last name is required.")
  @Size(min = 2, max = 255, message = "Last name must be between 2 and 255 characters.")
  private String lastName;

  @NotNull(message = "Employee type is required.")
  @Enumerated(EnumType.STRING)
  private EmployeeType employeeType;

  @Size(min = 11, max = 11, message = "PESEL must be 11 characters long.")
  @Column(unique = true)
  private String pesel;

  @Enumerated(EnumType.STRING)
  private WorkPermitType workPermitType;

  @Size(min = 11, max = 11, message = "Work permit ID must be 11 characters long.")
  @Column(unique = true)
  private String workPermitId;
}
