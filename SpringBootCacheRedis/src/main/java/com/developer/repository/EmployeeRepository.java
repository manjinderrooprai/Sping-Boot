package com.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.entity.EmployeeEntity;

/**
 * @author Manjinder.rooprai
 */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}