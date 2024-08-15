package com.example.EmployeeManagementSystem.DTO;

public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;
    private Long departmentId;

    public EmployeeDTO(Long id, String name, String email, Long departmentId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentId = departmentId;
    }
}
