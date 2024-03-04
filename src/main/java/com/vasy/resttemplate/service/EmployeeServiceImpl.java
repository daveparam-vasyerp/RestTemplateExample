package com.vasy.resttemplate.service;

import com.vasy.resttemplate.exception.ResourceNotFoundException;
import com.vasy.resttemplate.model.Employee;
import com.vasy.resttemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Found By Id:"+employeeId));
    }

    @Override
    public Employee addEmployee(Employee employee) {
       Employee employee1=new Employee(employee.getEmployeeName(),employee.getEmployeeSalary());
       employeeRepository.save(employee1);
        return employee1;
    }

    @Override
    public Employee updateEmployee(long employeeId, Employee employee) {
        Employee currentEmployee=employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not Exist By Id:"+employeeId));
        if(employee.getEmployeeName()!=null && employee.getEmployeeName().isEmpty()){
            currentEmployee.setEmployeeName(employee.getEmployeeName());
        }
        if(employee.getEmployeeSalary()>0){
            currentEmployee.setEmployeeSalary(employee.getEmployeeSalary());
        }

        return employeeRepository.save(currentEmployee);
    }

    @Override
    public String deleteEmployee(long employeeId) {
        employeeRepository.deleteById(employeeId);
        return "Employee Deleted By Id"+employeeId;
    }
}
