package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

  private final WarehouseRepository warehouseRepository;
  private final WorkerRepository workerRepository;
  private final ManagerRepository managerRepository;
  private final SettingRepository settingRepository;

  @Override
  public void addWorker(Long warehouseId, Long workerId) {
    var warehouse =
        warehouseRepository
            .findById(warehouseId)
            .orElseThrow(() -> new EntityNotFoundException("Warehouse not found."));
    var worker =
        workerRepository
            .findById(workerId)
            .orElseThrow(() -> new EntityNotFoundException("Worker not found."));
    var setting =
        settingRepository
            .findById(1L)
            .orElseThrow(() -> new EntityNotFoundException("Maximum number of workers not set."));
    if (warehouse.getWorkers().size() >= setting.getMaxWorkers()) {
      System.out.println("This warehouse already has the maximum number of workers.");
      return;
    }
    worker.setWarehouse(warehouse);
    workerRepository.save(worker);
  }

  @Override
  public void setManager(Long warehouseId, Long managerId) {
    var warehouse =
        warehouseRepository
            .findById(warehouseId)
            .orElseThrow(() -> new EntityNotFoundException("Warehouse not found."));
    var newManager =
        managerRepository
            .findById(managerId)
            .orElseThrow(() -> new EntityNotFoundException("Manager not found."));
    var oldManager = warehouse.getManager();
    if (oldManager != null) {
      oldManager.setWarehouse(null);
      managerRepository.save(oldManager);
    }
    if (newManager.getWarehouse() != null) {
      var otherWarehouse = newManager.getWarehouse();
      otherWarehouse.setManager(null);
      warehouseRepository.save(otherWarehouse);
    }
    warehouse.setManager(newManager);
    newManager.setWarehouse(warehouse);
    warehouseRepository.save(warehouse);
    managerRepository.save(newManager);
  }

  @Override
  public void editMaxItems(Long warehouseId, int maxItems) {
    var warehouse =
        warehouseRepository
            .findById(warehouseId)
            .orElseThrow(() -> new EntityNotFoundException("Warehouse not found."));
    if (warehouse.getItems().size() >= maxItems) {
      System.out.println("This warehouse has more items than the proposed maximum.");
      return;
    }
    warehouse.setMaxItems(maxItems);
    warehouseRepository.save(warehouse);
  }

  @Override
  public int getMaxWorkers() {
    var setting =
        settingRepository
            .findById(1L)
            .orElseThrow(() -> new EntityNotFoundException("Maximum number of workers not set."));
    return setting.getMaxWorkers();
  }

  @Override
  public void editMaxWorkers(int maxWorkers) {
    var setting =
        settingRepository
            .findById(1L)
            .orElseThrow(() -> new EntityNotFoundException("Maximum number of workers not set."));
    setting.setMaxWorkers(maxWorkers);
    settingRepository.save(setting);
  }
}
