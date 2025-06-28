package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Tracking number is required.")
  @Size(min = 2, max = 255, message = "Tracking number must be between 2 and 255 characters.")
  private String trackingNumber;

  @NotNull(message = "Status is required.")
  @PastOrPresent(message = "Status cannot be in the future.")
  private LocalDate placedOn;

  @PastOrPresent(message = "Status cannot be in the future.")
  private LocalDate deliveredOn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "buyer_id", nullable = false)
  private User buyer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;
}
