package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required.")
  @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters.")
  @Column(unique = true)
  private String name;

  @NotBlank(message = "Description is required.")
  @Size(min = 2, max = 255, message = "Description must be between 2 and 255 characters.")
  private String description;

  @PositiveOrZero(message = "Monthly sales must be greater than or equal to 0.")
  private int monthlySales;

  @ManyToMany(mappedBy = "categories")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Item> items = new HashSet<>();
}
