package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {}
