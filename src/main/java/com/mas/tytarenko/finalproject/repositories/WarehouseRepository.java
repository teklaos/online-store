package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Warehouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends CrudRepository<Warehouse, Long> {}
