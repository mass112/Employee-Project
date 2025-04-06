package com.example.Employee.controller;


import com.example.Employee.dto.EmployeeDTO;
import com.example.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee=employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable  Long id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployess(){
        List<EmployeeDTO> employeeDTOS=employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOS,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody  EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee=employeeService.updateEmployee(id,employeeDTO);
        return new ResponseEntity<>(savedEmployee,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}
