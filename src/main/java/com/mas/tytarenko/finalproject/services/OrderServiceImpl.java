package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Order;
import com.mas.tytarenko.finalproject.models.enums.Status;
import com.mas.tytarenko.finalproject.repositories.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public void createOrder(Order order) {
    orderRepository.save(order);
  }

  @Override
  public void editOrder(Order order) {
    orderRepository.save(order);
  }

  @Override
  public void removeOrder(Long id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found."));
    orderRepository.delete(order);
  }

  @Override
  public void placeOrder(Long id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found."));
    order.setStatus(Status.PROCESSING);
  }

  @Override
  public void shipOrder(Long id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found."));
    order.setStatus(Status.SHIPPED);
  }

  @Override
  public void confirmDelivery(Long id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found."));
    order.setStatus(Status.DELIVERED);
  }

  @Override
  public void cancelOrder(Long id) {
    var order =
        orderRepository
            .findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Order not found."));
    order.setStatus(Status.CANCELLED);
  }
}
