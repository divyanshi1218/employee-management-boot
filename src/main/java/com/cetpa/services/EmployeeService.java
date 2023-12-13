package com.cetpa.services;

import java.util.List;

import com.cetpa.entities.Employee;

public interface EmployeeService 
{
	void saveRecord(Employee employee);
	Employee getEmployee(int empid);
	void deleteRecord(int empid);
	void updateRecord(Employee employee);
	List<Employee> getList();
	List<String> getDepartmentList();
	List<Employee> getListDepartmentWise(String department);
}
