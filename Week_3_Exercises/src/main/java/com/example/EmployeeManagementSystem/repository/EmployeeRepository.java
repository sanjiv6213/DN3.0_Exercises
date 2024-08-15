package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.DTO.EmployeeDTO;
import com.example.EmployeeManagementSystem.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.EmployeeManagementSystem.projection.EmployeeProjection;
import com.example.EmployeeManagementSystem.projection.CustomEmployeeProjection;



import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

    // Derived query methods

    List<Employee> findByNameContaining(String name);
    
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId")
    List<Employee> findEmployeesByDepartmentId(Long departmentId);

    
    // Find employees by name
    List<Employee> findByEmail(String email); // Uses @NamedQuery "Department.findByEmail"
    
    
    List<EmployeeProjection> findByName(String name);
    
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e WHERE e.name = ?1")
    List<EmployeeDTO> findByDepartmentId(Long departmentId);
    
    List<CustomEmployeeProjection> findByDepartmentName(String name);

}
