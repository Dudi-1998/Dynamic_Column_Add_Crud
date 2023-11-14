package com.NumetryMockTest.Employee.service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.NumetryMockTest.Employee.dto.Employee;
import com.NumetryMockTest.Employee.repository.EmployeeRepo;

@Service
public class EmployeeServiceImp implements EmployeeService {
	 
	@Autowired
	private EmployeeRepo repo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		repo.save(employee);
		return employee;
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = repo.findAll();
		return employees;
	}
	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = repo.findById(id);
		if(employee.isPresent())
		{
			return employee.get();
		}
		return null;
	}
	@Override
	public Employee deleteEmployeeById(int id) {
		Optional<Employee> employee = repo.findById(id);
		if (employee.isPresent()) {
			repo.deleteById(id);
			return employee.get();
			
		}
		return null;
	}
	@Override
	public Employee updateEmployeeById(int id, Employee employee) {
		Optional<Employee> optional = repo.findById(id);
		if(optional.isPresent())
		{
			employee.setId(id);
			repo.save(employee);
			return employee;
		}
		return null;
	}
	@Override
	public Employee addDynamicColumn(int id, String columnName, String columnValue) {
		Optional<Employee> optionalEmployee = repo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.getDynamicColumns().put(columnName, columnValue);
            return repo.save(employee);
        }
        return null;
	}
	@Override
	public List<Employee> searchEmployees(String keyword) {
		return repo.findByNameContainingOrDepartmentContainingOrEmailContainingOrRoleContaining(keyword, keyword, keyword, keyword);
	}
	@Override
	public List<Employee> getAllEmployeesSorted(String sortBy) {
	
		   Sort sort = Sort.by(Direction.ASC,sortBy);
	        return repo.findAll(sort);
	}
	@Override
	public List<Employee> getAllEmployeesPaginated(int page, int size) {
	    Pageable pageable = PageRequest.of(page, size);
	    return repo.findAll(pageable).getContent();
	}
	
	
}
