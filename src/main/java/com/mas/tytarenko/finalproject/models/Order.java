package com.mas.tytarenko.finalproject.models;

import com.mas.tytarenko.finalproject.models.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import lombok.*;

@Entity
@Table(name = "user_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "Status is required.")
  @Enumerated(EnumType.STRING)
  private Status status;

  @OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Shipment> shipments = new HashSet<>();

  public double getTotalPrice() {
    if (items == null || items.isEmpty()) {
      return 0.0;
    }
    return items.stream().mapToDouble(Item::getPrice).sum();
  }

  @ManyToMany
  @JoinTable(
      name = "order_items",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "item_id"))
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Item> items = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "order_carriers",
      joinColumns = @JoinColumn(name = "order_id"),
      inverseJoinColumns = @JoinColumn(name = "carrier_id"))
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @Builder.Default
  private Set<Carrier> carriers = new HashSet<>();

  @PrePersist
  @PreUpdate
  private void validateOrder() {
    if (carriers == null || carriers.isEmpty()) {
      throw new IllegalStateException("Order must contain at least one carrier.");
    }
    if (items == null || items.isEmpty()) {
      throw new IllegalStateException("Order must contain at least one item.");
    }
  }
}
