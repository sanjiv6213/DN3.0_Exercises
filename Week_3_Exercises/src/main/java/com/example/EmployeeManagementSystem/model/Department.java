package com.example.EmployeeManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import org.hibernate.annotations.Immutable;


@Entity
@Table(name = "departments")
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({
    @NamedQuery(name = "Department.findByName", query = "SELECT d FROM Department d WHERE d.name = :name")
})
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Immutable
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
   

    @OneToMany(mappedBy = "department")
    @BatchSize(size = 10)
    private List<Employee> employees;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;
}



