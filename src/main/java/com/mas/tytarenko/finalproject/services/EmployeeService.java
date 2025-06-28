package com.mas.tytarenko.finalproject.services;

import com.mas.tytarenko.finalproject.models.Employee;
import com.mas.tytarenko.finalproject.models.enums.Status;
import com.mas.tytarenko.finalproject.models.enums.WorkPermitType;

/**
 * Service interface for managing {@link Employee} entities.
 *
 * <p>Provides operations to change an employee's {@link Status} between {@code CITIZEN} and {@code
 * IMMIGRANT}, modifying relevant identification data.
 */
public interface EmployeeService {

  /**
   * Converts an employee to {@code CITIZEN} status.
   *
   * <p>Clears any existing work permit data and assigns a PESEL.
   *
   * @param employeeId the ID of the employee to convert
   * @param pesel the national identification number to assign
   */
  void changeToCitizen(Long employeeId, String pesel);

  /**
   * Converts an employee to {@code IMMIGRANT} status.
   *
   * <p>Clears any existing PESEL and assigns work permit details.
   *
   * @param employeeId the ID of the employee to convert
   * @param workPermitType the type of work permit to assign
   * @param workPermitId the identifier of the work permit
   */
  void changeToImmigrant(Long employeeId, WorkPermitType workPermitType, String workPermitId);
}
