package com.NumetryMockTest.Employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NumetryMockTest.Employee.dto.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	List<Employee>findByNameContainingOrDepartmentContainingOrEmailContainingOrRoleContaining(String name, String department, String email, String role);

}
