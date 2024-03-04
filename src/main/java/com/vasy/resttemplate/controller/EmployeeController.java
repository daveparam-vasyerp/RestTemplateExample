package com.vasy.resttemplate.controller;

import com.vasy.resttemplate.model.Employee;
import com.vasy.resttemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/get-all-employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/get-employee-by-id/{employeeId}")
    public Employee getEmployeeById(@PathVariable long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
    @PostMapping("/add-employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/update-employee/{employeeId}")
    public Employee updateEmployee(@PathVariable long employeeId,@RequestBody Employee employee) {
        return employeeService.updateEmployee(employeeId,employee);
    }
    @DeleteMapping("/delete-employee/{employeeId}")
    public String deleteEmployee(@PathVariable long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}




