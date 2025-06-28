package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Manager;
import com.mas.tytarenko.finalproject.repositories.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

  private final ManagerRepository managerRepository;

  @Override
  public void createManager(Manager manager) {
    managerRepository.save(manager);
  }
}
