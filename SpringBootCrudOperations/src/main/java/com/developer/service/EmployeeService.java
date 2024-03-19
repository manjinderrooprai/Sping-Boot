package com.developer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.entity.EmployeeEntity;
import com.developer.model.Employee;
import com.developer.repository.EmployeeRepository;
import com.developer.utils.UtilityHelper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Manjinder.rooprai
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<Employee> findAll() {
        List<EmployeeEntity> EmployeeEntityList = employeeRepository.findAll();
        return objectMapper.convertValue(EmployeeEntityList, new TypeReference<List<Employee>>() {
        });
    }

    public Employee findById(int id) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isEmpty()) {
            return null;
        }
        return objectMapper.convertValue(optionalEmployeeEntity.get(), Employee.class);
    }

    public Employee save(Employee employee) {
        @SuppressWarnings("null")
        EmployeeEntity employeeEntity = employeeRepository
                .save(objectMapper.convertValue(employee, EmployeeEntity.class));
        return objectMapper.convertValue(employeeEntity, Employee.class);
    }

    public Employee update(int id, Employee employee) {
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

    public void delete(int id) {
        employeeRepository.findById(id).ifPresent(Employee -> employeeRepository.delete(Employee));
    }

    public List<Employee> populateEmployees() {
        @SuppressWarnings("null")
        List<EmployeeEntity> listOfEmployeeEntity = employeeRepository
                .saveAllAndFlush(UtilityHelper.employeeSupplier.get());
        return objectMapper.convertValue(listOfEmployeeEntity, new TypeReference<List<Employee>>() {
        });
    }

}
