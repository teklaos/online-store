package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Wishlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends CrudRepository<Wishlist, Long> {}
