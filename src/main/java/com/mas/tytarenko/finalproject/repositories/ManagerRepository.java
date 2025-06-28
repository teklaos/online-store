package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {}
