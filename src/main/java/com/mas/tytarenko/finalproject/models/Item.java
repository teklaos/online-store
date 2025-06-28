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
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Name is required.")
  @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters.")
  private String name;

  @NotBlank(message = "Description is required.")
  @Size(min = 2, max = 255, message = "Description must be between 2 and 255 characters.")
  private String description;

  @PositiveOrZero(message = "Weight must be greater than or equal to 0.")
  private double weight;

  @Positive(message = "Price must be greater than 0.")
  private double price;

  @PositiveOrZero(message = "Number of items in stock must be greater than or equal to 0.")
  private int inStock;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "vendor_id", nullable = false, updatable = false)
  private User vendor;

  @ManyToMany(mappedBy = "items")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Wishlist> wishlists = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "item_categories",
      joinColumns = @JoinColumn(name = "item_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Category> categories = new HashSet<>();

  @ManyToMany(mappedBy = "items")
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Order> orders = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_id")
  private Warehouse warehouse;

  @PrePersist
  @PreUpdate
  private void validateItem() {
    if (categories == null || categories.isEmpty()) {
      throw new IllegalStateException("Item must belong to at least one category.");
    }
  }
}
