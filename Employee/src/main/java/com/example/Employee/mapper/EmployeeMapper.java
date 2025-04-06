package com.example.Employee.mapper;


import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapToEmployeeDto(Employee emp){
        return new EmployeeDTO(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        Employee employee=new Employee();

        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        return employee;
    }
}