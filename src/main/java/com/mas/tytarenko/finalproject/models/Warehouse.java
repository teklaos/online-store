package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Address is required.")
  @Embedded
  private Address address;

  @Positive(message = "Maximum capacity of items must be greater than 0.")
  private int maxItems;

  @OneToMany(mappedBy = "warehouse")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Item> items = new HashSet<>();

  @OneToMany(mappedBy = "warehouse")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Worker> workers = new HashSet<>();

  @OneToOne
  @JoinColumn(name = "manager_id")
  private Manager manager;
}
