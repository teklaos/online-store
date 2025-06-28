package com.mas.tytarenko.finalproject.models;

import com.mas.tytarenko.finalproject.models.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

@Entity
@Table(name = "app_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Username is required.")
  @Size(min = 2, max = 255, message = "Username must be between 2 and 255 characters.")
  private String username;

  @NotBlank(message = "Email is required.")
  @Size(min = 3, max = 255, message = "Email must be between 3 and 255 characters.")
  @Column(unique = true)
  @Email(message = "Email is in invalid format.")
  private String email;

  private boolean isBlocked;

  @NotNull(message = "User roles are required.")
  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role")
  @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
  @Builder.Default
  private Set<UserRole> userRoles = new HashSet<>();

  @Size(min = 2, max = 255, message = "Store name must be between 2 and 255 characters.")
  private String storeName;

  public Double getAverageRating() {
    if (!userRoles.contains(UserRole.VENDOR)) {
      System.out.println("User is not a vendor.");
      return null;
    }
    if (receivedReviews == null || receivedReviews.isEmpty()) {
      return 0.0;
    }
    return receivedReviews.stream().mapToDouble(Review::getRating).average().orElse(0.0);
  }

  public Integer getNumberOfReports() {
    if (!userRoles.contains(UserRole.VENDOR)) {
      System.out.println("User is not a vendor.");
      return null;
    }
    if (receivedReviews == null || receivedReviews.isEmpty()) {
      return 0;
    }
    return (int) receivedReviews.stream().filter(Review::isReport).count();
  }

  @CollectionTable(name = "shipping_addresses")
  @ElementCollection(targetClass = Address.class, fetch = FetchType.EAGER)
  private Set<Address> shippingAddresses;

  @PastOrPresent(message = "Date of birth cannot be in the future.")
  private LocalDate dateOfBirth;

  @OneToMany(mappedBy = "vendor", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Item> items;

  @OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Shipment> shipments;

  @OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Wishlist> wishlists;

  @OneToMany(mappedBy = "buyer", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Review> submittedReviews;

  @OneToMany(mappedBy = "vendor", cascade = CascadeType.REMOVE)
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  private Set<Review> receivedReviews;
}
