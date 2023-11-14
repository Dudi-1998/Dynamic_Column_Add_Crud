package com.NumetryMockTest.Employee.dto;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.JoinColumn;
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String email;
	String department;
	Date dateOfJoining;
	String role;
	@ElementCollection
    @MapKeyColumn(name = "dynamic_key")
    @Column(name = "dynamic_value")
    @CollectionTable(name = "employee_dynamic_columns", joinColumns = @JoinColumn(name = "employee_id"))
    private Map<String, String> dynamicColumns = new HashMap<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Map<String, String> getDynamicColumns() {
		return dynamicColumns;
	}
	public void setDynamicColumns(Map<String, String> dynamicColumns) {
		this.dynamicColumns = dynamicColumns;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", dateOfJoining=" + dateOfJoining + ", role=" + role + ", dynamicColumns=" + dynamicColumns + "]";
	}
	
	
	
}
