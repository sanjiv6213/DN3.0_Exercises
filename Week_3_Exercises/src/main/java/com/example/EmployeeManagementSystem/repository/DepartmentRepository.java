package com.example.EmployeeManagementSystem.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.EmployeeManagementSystem.model.Department;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    // Derived query methods
    List<Department> findByNameContaining(String name);
    List<Department> findByName(String name);
    @Query("SELECT d FROM Department d WHERE d.name = :name")
    List<Department> findDepartmentsByName(String name);
}
