package com.example.EmployeeManagementSystem.model;

	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import jakarta.persistence.*;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.security.Timestamp;
import java.time.LocalDateTime;
	import org.springframework.data.annotation.CreatedDate;
	import org.springframework.data.annotation.LastModifiedDate;
	import org.hibernate.annotations.Generated;
	import org.hibernate.annotations.GenerationTime;


	@SuppressWarnings("deprecation")
	@Entity
	@EntityListeners(AuditingEntityListener.class)

	@Table(name = "employees")
	
	@NamedQueries({
	    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
	    @NamedQuery(name = "Employee.findByDepartmentId", query = "SELECT e FROM Employee e WHERE e.department.id = :departmentId"),
	    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
	})
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class Employee {

	    @Id
	    
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private String email;
	    
		@Generated(GenerationTime.ALWAYS)
	    @Column(name = "updated_timestamp", insertable = false, updatable = false)
	    private Timestamp updatedTimestamp;
	    
	    // Getter and Setter for name
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    // Getter and Setter for email
	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    // Getter and Setter for department
	    public Department getDepartment() {
	        return department;
	    }

	    public void setDepartment(Department department) {
	        this.department = department;
	    }


	    @CreatedDate
	    @Column(name = "created_date", updatable = false)
	    private LocalDateTime createdDate;

	    @LastModifiedDate
	    @Column(name = "last_modified_date")
	    private LocalDateTime lastModifiedDate;
	    
	    @ManyToOne
	    @JoinColumn(name = "department_id")
	    private Department department;
	}
