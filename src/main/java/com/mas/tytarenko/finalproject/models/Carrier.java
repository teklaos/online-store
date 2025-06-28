package com.mas.tytarenko.finalproject.models;

import com.mas.tytarenko.finalproject.models.enums.DeliveryMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carrier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Company name is required.")
  @Size(min = 2, max = 255, message = "Company name must be between 2 and 255 characters.")
  private String companyName;

  @NotNull(message = "Delivery methods are required.")
  @Enumerated(EnumType.STRING)
  @CollectionTable(
      name = "carrier_delivery_methods",
      joinColumns = @JoinColumn(name = "carrier_id"))
  @Column(name = "delivery_method")
  @ElementCollection(targetClass = DeliveryMethod.class, fetch = FetchType.EAGER)
  @Builder.Default
  private Set<DeliveryMethod> deliveryMethods = new HashSet<>();
}
