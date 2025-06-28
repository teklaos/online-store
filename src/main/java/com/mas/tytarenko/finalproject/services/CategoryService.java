package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Category;

/**
 * Service interface for managing {@link Category} entities.
 *
 * <p>Defines operations related to the creation and persistence of categories.
 */
public interface CategoryService {

  /**
   * Persists a new {@link Category} entity.
   *
   * @param category the category to be saved
   */
  void createCategory(Category category);
}
