package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.enums.EmployeeType;
import com.mas.tytarenko.finalproject.models.enums.WorkPermitType;
import com.mas.tytarenko.finalproject.repositories.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  @Override
  public void changeToCitizen(Long employeeId, String pesel) {
    var employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
    if (employee.getEmployeeType() == EmployeeType.CITIZEN) {
      System.out.println("This employee is already a citizen.");
      return;
    }
    employee.setWorkPermitType(null);
    employee.setWorkPermitId(null);
    employee.setEmployeeType(EmployeeType.CITIZEN);
    employee.setPesel(pesel);
    employeeRepository.save(employee);
  }

  @Override
  public void changeToImmigrant(
      Long employeeId, WorkPermitType workPermitType, String workPermitId) {
    var employee =
        employeeRepository
            .findById(employeeId)
            .orElseThrow(() -> new EntityNotFoundException("Employee not found."));
    if (employee.getEmployeeType() == EmployeeType.IMMIGRANT) {
      System.out.println("This employee is already an immigrant.");
      return;
    }
    employee.setPesel(null);
    employee.setEmployeeType(EmployeeType.IMMIGRANT);
    employee.setWorkPermitType(workPermitType);
    employee.setWorkPermitId(workPermitId);
    employeeRepository.save(employee);
  }
}
