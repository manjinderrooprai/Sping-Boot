package com.developer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.developer.entity.EmployeeEntity;
import com.developer.model.Employee;
import com.developer.repository.EmployeeRepository;
import com.developer.utils.UtilityHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Manjinder.rooprai
 */
@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Cacheable(value = "employees")
    public List<Employee> findAll() {
        log.info("get all the employees from database");
        List<EmployeeEntity> EmployeeEntityList = employeeRepository.findAll();
        return objectMapper.convertValue(EmployeeEntityList, new TypeReference<List<Employee>>() {
        });
    }

    @Cacheable(value = "employees", key = "#p0")
    public Employee findById(long id) {
        log.info("get employee from database");
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isEmpty()) {
            return null;
        }
        return objectMapper.convertValue(optionalEmployeeEntity.get(), Employee.class);
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public Employee save(Employee employee) {
        log.info("save employee in database");
        @SuppressWarnings("null")
        EmployeeEntity employeeEntity = employeeRepository
                .save(objectMapper.convertValue(employee, EmployeeEntity.class));
        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    @CachePut(cacheNames = "employees", key = "#p0")
    public Employee update(long id, Employee employee) {
        log.info("update employee in database");
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isEmpty()) {
            return null;
        }
        employee.setId(id);
        @SuppressWarnings("null")
        EmployeeEntity employeeEntity = employeeRepository
                .save(objectMapper.convertValue(employee, EmployeeEntity.class));
        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public void delete(long id) {
        log.info("delete employee in database");
        employeeRepository.findById(id).ifPresent(employee -> employeeRepository.delete(employee));
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public List<Employee> populateEmployees() {
        log.info("populate employees in database");
        @SuppressWarnings("null")
        List<EmployeeEntity> listOfEmployeeEntity = employeeRepository
                .saveAllAndFlush(UtilityHelper.employeeSupplier.get());
        return objectMapper.convertValue(listOfEmployeeEntity, new TypeReference<List<Employee>>() {
        });
    }

    @CacheEvict(cacheNames = "employees", allEntries = true)
    public void cacheEvict() {
    }

}
