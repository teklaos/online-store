package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {}
