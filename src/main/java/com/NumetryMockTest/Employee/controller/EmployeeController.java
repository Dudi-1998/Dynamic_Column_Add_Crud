package com.NumetryMockTest.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NumetryMockTest.Employee.dto.Employee;
import com.NumetryMockTest.Employee.service.EmployeeServiceImp;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImp service;
	
	@PostMapping("/saveEmp")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return service.createEmployee(employee);
	}
	
	@GetMapping("/getAllEmp")
	public List<Employee> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@GetMapping("/getEmpById/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return service.getEmployeeById(id);
	}
	
	@DeleteMapping("/deleteEmpById/{id}")
	public Employee deleteEmployeeById(@PathVariable int id)
	{
		return service.deleteEmployeeById(id);
	}
	
	@PutMapping("/updateEmpById/{id}")
	public Employee updateEmployeeById(@PathVariable int id, @RequestBody Employee employee)
	{
		return service.updateEmployeeById(id, employee);
	}
	
	  @PostMapping("/{id}/dynamic-column")
	    public ResponseEntity<Employee> addDynamicColumn(
	            @PathVariable int id,
	            @RequestParam String columnName,
	            @RequestParam String columnValue) {
	        Employee updatedEmployee = service.addDynamicColumn(id, columnName, columnValue);
	        if (updatedEmployee != null) {
	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	  
	  @GetMapping("/search")
	  public List<Employee> searchEmployees(@RequestParam String key)
	  {
		  return service.searchEmployees(key);
	  }
	  
	  @GetMapping("/sort")
	  public List<Employee> sortEmployee(@RequestParam String sortBy)
	  {
		  return service.getAllEmployeesSorted(sortBy);
	  }
	  
	  @GetMapping("/paginated")
	    public List<Employee> getAllEmployeesPaginated(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {
	        return service.getAllEmployeesPaginated(page, size);
	  }
}
