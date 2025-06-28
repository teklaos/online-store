package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Manager;

/**
 * Service interface for managing {@link Manager} entities.
 *
 * <p>Provides functionality to create and persist new manager records.
 */
public interface ManagerService {

  /**
   * Creates and persists a new manager.
   *
   * @param manager the manager entity to be created
   */
  void createManager(Manager manager);
}
