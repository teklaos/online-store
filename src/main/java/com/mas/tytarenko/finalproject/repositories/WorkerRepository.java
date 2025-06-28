package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {}
