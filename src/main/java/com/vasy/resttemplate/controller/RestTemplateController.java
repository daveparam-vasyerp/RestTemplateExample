package com.vasy.resttemplate.controller;

import com.vasy.resttemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1")

public class RestTemplateController {
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URI="http://localhost:8080";
    private final String URI_EMPLOYEES=BASE_URI+"/get-all-employees";
    private final String URI_GET_SINGLE=BASE_URI+"/get-employee-by-id/";
    private final String URI_ADD=BASE_URI+"/add-employee";
    private final String URI_UPDATE=BASE_URI+"/update-employee/";
    private final String URI_DELETE=BASE_URI+"/delete-employee/";

    @GetMapping("/get-all-employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(URI_EMPLOYEES, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>() {
        });

    }
    @GetMapping("get-employee-by-id/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") long employeeId){
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(URI_GET_SINGLE+employeeId,HttpMethod.GET,entity, Employee.class);
    }
    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity = new HttpEntity<>(employee,headers);
        return restTemplate.exchange(URI_ADD, HttpMethod.POST, entity, Employee.class);
    }
    @PutMapping("/update-employee/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long employeeId,@RequestBody Employee employee) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity=new HttpEntity<>(employee,headers);
        return restTemplate.exchange(URI_UPDATE + employeeId,HttpMethod.PUT,entity,Employee.class);
    }
    @DeleteMapping("/delete-employee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long employeeId) {
        HttpHeaders headers=new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<?> entity=new HttpEntity<>(headers);
        return restTemplate.exchange(URI_DELETE+employeeId,HttpMethod.DELETE,entity,String.class);
    }
}
