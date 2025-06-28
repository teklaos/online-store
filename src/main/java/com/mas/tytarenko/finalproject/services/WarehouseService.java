package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Warehouse;

/**
 * Service interface for managing {@link Warehouse} entities.
 *
 * <p>Provides methods to manage workers, managers, and warehouse capacity constraints.
 */
public interface WarehouseService {

  /**
   * Adds a worker to the specified warehouse.
   *
   * @param warehouseId the unique identifier of the warehouse
   * @param workerId the unique identifier of the worker to add
   */
  void addWorker(Long warehouseId, Long workerId);

  /**
   * Assigns a manager to the specified warehouse.
   *
   * @param warehouseId the unique identifier of the warehouse
   * @param managerId the unique identifier of the manager to assign
   */
  void setManager(Long warehouseId, Long managerId);

  /**
   * Updates the maximum number of items allowed in the specified warehouse.
   *
   * @param warehouseId the unique identifier of the warehouse
   * @param maxItems the new maximum capacity for items
   */
  void editMaxItems(Long warehouseId, int maxItems);

  /**
   * Retrieves the maximum number of workers allowed across warehouses.
   *
   * @return the maximum number of workers
   */
  int getMaxWorkers();

  /**
   * Updates the maximum number of workers allowed across warehouses.
   *
   * @param maxWorkers the new maximum number of workers
   */
  void editMaxWorkers(int maxWorkers);
}
