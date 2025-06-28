package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Order;

/**
 * Service interface for managing {@link Order} entities.
 *
 * <p>Provides operations to create, modify, and manage the lifecycle of orders, including placing,
 * shipping, confirming delivery, and cancellation.
 */
public interface OrderService {

  /**
   * Creates and persists a new order.
   *
   * @param order the order entity to be created
   */
  void createOrder(Order order);

  /**
   * Updates an existing order.
   *
   * @param order the updated order entity
   */
  void editOrder(Order order);

  /**
   * Removes an order by its ID.
   *
   * @param id the ID of the order to be removed
   */
  void removeOrder(Long id);

  /**
   * Places an order, transitioning it to a placed state.
   *
   * @param id the ID of the order to be placed
   */
  void placeOrder(Long id);

  /**
   * Marks an order as shipped.
   *
   * @param id the ID of the order to be shipped
   */
  void shipOrder(Long id);

  /**
   * Confirms the delivery of an order.
   *
   * @param id the ID of the order to confirm delivery for
   */
  void confirmDelivery(Long id);

  /**
   * Cancels an order.
   *
   * @param id the ID of the order to be canceled
   */
  void cancelOrder(Long id);
}
