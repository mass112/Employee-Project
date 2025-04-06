package com.example.Employee.service;

import com.example.Employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO empDto);

    EmployeeDTO getEmployeeById(Long id);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
