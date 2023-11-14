package com.NumetryMockTest.Employee.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.NumetryMockTest.Employee.controller.EmployeeController;
import com.NumetryMockTest.Employee.dto.Employee;
import com.NumetryMockTest.Employee.service.EmployeeServiceImp;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	@Mock
    private EmployeeServiceImp employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    void saveEmployee() {
        Employee employee = new Employee();
        when(employeeService.createEmployee(employee)).thenReturn(employee);

        Employee savedEmployee = employeeController.saveEmployee(employee);

        assertEquals(employee, savedEmployee);
        verify(employeeService, times(1)).createEmployee(employee);
    }

    @Test
    void getAllEmployee() {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        when(employeeService.getAllEmployee()).thenReturn(employees);

        List<Employee> result = employeeController.getAllEmployee();

        assertEquals(employees, result);
        verify(employeeService, times(1)).getAllEmployee();
    }

    @Test
    void getEmployeeById() {
        int employeeId = 1;
        Employee employee = new Employee();
        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);

        Employee result = employeeController.getEmployeeById(employeeId);

        assertEquals(employee, result);
        verify(employeeService, times(1)).getEmployeeById(employeeId);
    }

    // Similar tests for deleteEmployeeById, updateEmployeeById, and other methods

    @Test
    void addDynamicColumn() {
        int id = 1;
        String columnName = "column";
        String columnValue = "value";
        Employee updatedEmployee = new Employee();
        when(employeeService.addDynamicColumn(id, columnName, columnValue)).thenReturn(updatedEmployee);

        ResponseEntity<Employee> responseEntity = employeeController.addDynamicColumn(id, columnName, columnValue);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(updatedEmployee, responseEntity.getBody());
        verify(employeeService, times(1)).addDynamicColumn(id, columnName, columnValue);
    }
    @Test
    void searchEmployees() {
        String key = "John";
        List<Employee> searchResults = Arrays.asList(new Employee(), new Employee());
        when(employeeService.searchEmployees(key)).thenReturn(searchResults);

        List<Employee> result = employeeController.searchEmployees(key);

        assertEquals(searchResults, result);
        verify(employeeService, times(1)).searchEmployees(key);
    }

    // Assuming a method in the service to handle sorting logic
    @Test
    void sortEmployee() {
        String sortBy = "name";
        List<Employee> sortedEmployees = Arrays.asList(new Employee(), new Employee());
        when(employeeService.getAllEmployeesSorted(sortBy)).thenReturn(sortedEmployees);

        List<Employee> result = employeeController.sortEmployee(sortBy);

        assertEquals(sortedEmployees, result);
        verify(employeeService, times(1)).getAllEmployeesSorted(sortBy);
    }

    // Assuming a method in the service to handle pagination logic
    @Test
    void getAllEmployeesPaginated() {
        int page = 1;
        int size = 10;
        List<Employee> paginatedEmployees = Arrays.asList(new Employee(), new Employee());
        when(employeeService.getAllEmployeesPaginated(page, size)).thenReturn(paginatedEmployees);

        List<Employee> result = employeeController.getAllEmployeesPaginated(page, size);

        assertEquals(paginatedEmployees, result);
        verify(employeeService, times(1)).getAllEmployeesPaginated(page, size);
    }

}
