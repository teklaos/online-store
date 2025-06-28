package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {}
