package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wishlist {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required.")
  @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters.")
  private String name;

  @NotNull(message = "Creation date is required.")
  @PastOrPresent(message = "Creation date cannot be in the future.")
  private LocalDate dateCreated;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "buyer_id", nullable = false, updatable = false)
  private User buyer;

  @ManyToMany
  @JoinTable(
      name = "wishlist_items",
      joinColumns = @JoinColumn(name = "wishlist_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id"))
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Item> items = new HashSet<>();
}
