package com.developer.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.developer.model.Employee;
import com.developer.service.EmployeeService;

/**
 * @author Manjinder.rooprai
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employeeList = employeeService.findAll();
        return ResponseEntity.ok().body(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable(required = true, value = "id") long id) {
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> save(@RequestBody(required = true) Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).body(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable(required = true, value = "id") long id,
            @RequestBody(required = true) Employee employee) {
        Employee updatedEmployee = employeeService.update(id, employee);
        return ResponseEntity.ok().body(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(required = true, value = "id") long id) {
        employeeService.delete(id);
        return ResponseEntity.ok().body("Deleted successfully...!");
    }

    @GetMapping("/populate")
    public ResponseEntity<List<Employee>> populateEmployees() {
        return ResponseEntity.ok().body(employeeService.populateEmployees());
    }

    @GetMapping("/cache/evict")
    public ResponseEntity<String> cacheEvict() {
        employeeService.cacheEvict();
        return ResponseEntity.ok().body("Cache Evict successfully...!");
    }
}