package com.example.EmployeeManagementSystem.projection;
import org.springframework.beans.factory.annotation.Value;


public interface CustomEmployeeProjection {

	 @Value("#{target.department.name}")
	    String getDepartmentName();
}
