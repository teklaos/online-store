package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {}
