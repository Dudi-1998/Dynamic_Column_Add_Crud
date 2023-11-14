package com.NumetryMockTest.Employee.service;

import java.util.List;

import com.NumetryMockTest.Employee.dto.Employee;



public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public java.util.List<Employee> getAllEmployee();
	public Employee getEmployeeById(int id);
	public Employee deleteEmployeeById(int id);
	public Employee updateEmployeeById(int id, Employee employee);
	public Employee addDynamicColumn(int id, String columnName, String columnValue);
	public List<Employee> searchEmployees(String keyword);
	public List<Employee> getAllEmployeesSorted(String sortBy);
	public List<Employee> getAllEmployeesPaginated(int page, int size);

}
