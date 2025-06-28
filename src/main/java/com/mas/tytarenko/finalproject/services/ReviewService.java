package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Review;

/**
 * Service interface for managing {@link Review} entities.
 *
 * <p>Provides functionality to create and persist new product or service reviews.
 */
public interface ReviewService {
  /**
   * Creates and persists a new review.
   *
   * @param review the review entity to be created
   */
  void createReview(Review review);
}
