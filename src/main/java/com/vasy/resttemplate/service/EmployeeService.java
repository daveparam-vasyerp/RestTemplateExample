package com.vasy.resttemplate.service;

import com.vasy.resttemplate.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(long employeeId);
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(long employeeId,Employee employee);
    public String deleteEmployee(long employeeId);

}
