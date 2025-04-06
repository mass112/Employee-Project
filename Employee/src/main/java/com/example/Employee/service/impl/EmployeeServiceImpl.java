package com.example.Employee.service.impl;

import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.entity.Employee;
import com.example.Employee.exception.CustomException;
import com.example.Employee.mapper.EmployeeMapper;
import com.example.Employee.repository.EmployeeRepository;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public EmployeeDTO createEmployee(EmployeeDTO empDto){
        Employee employee= EmployeeMapper.mapToEmployee(empDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new CustomException("user not found"+id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    public List<EmployeeDTO> getAllEmployees(){

        List<Employee> employees=employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();

        for(Employee e:employees){
            EmployeeDTO employeeDTO=EmployeeMapper.mapToEmployeeDto(e);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    public EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new CustomException("user not found"+id));
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        Employee savedEmployee=employeeRepository.save(employee);
        return  EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    public void deleteEmployee(Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow(()->new CustomException("user not found"+id));
        employeeRepository.deleteById(id);
    }



}
