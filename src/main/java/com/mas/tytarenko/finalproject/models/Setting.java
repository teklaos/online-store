package com.mas.tytarenko.finalproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity used to persistently store static configuration attributes of the application.
 *
 * <p>This class holds settings that remain constant during application runtime but need to be saved
 * in the database for persistence and possible future changes.
 *
 * <p>The entity has a fixed primary key with value {@code 1L}, representing a singleton settings
 * record.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Setting {

  @Id private Long id = 1L;

  @Positive(message = "Maximum capacity of workers must be greater than 0.")
  private int maxWorkers;
}
