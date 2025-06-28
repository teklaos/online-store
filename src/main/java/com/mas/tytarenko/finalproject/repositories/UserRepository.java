package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
