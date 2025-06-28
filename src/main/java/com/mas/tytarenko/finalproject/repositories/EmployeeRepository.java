package com.mas.tytarenko.finalproject.repositories;

import com.mas.tytarenko.finalproject.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
