package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

  @NotBlank(message = "Street is required.")
  @Size(min = 2, max = 255, message = "Street must be between 2 and 255 characters.")
  private String street;

  @Positive(message = "Street number must be greater than 0.")
  private int number;

  @NotBlank(message = "Zip code is required.")
  @Size(min = 2, max = 6, message = "Zip code must be between 2 and 255 characters.")
  private String zip;

  @NotBlank(message = "City is required.")
  @Size(min = 2, max = 255, message = "City must be between 2 and 255 characters.")
  private String city;
}
