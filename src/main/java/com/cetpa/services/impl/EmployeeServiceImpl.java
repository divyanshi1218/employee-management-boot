package com.cetpa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.entities.Employee;
import com.cetpa.repositories.EmployeeRepository;
import com.cetpa.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	public void saveRecord(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public Employee getEmployee(int empid) 
	{
		return employeeRepository.findById(empid).orElse(null);
	}
	public void deleteRecord(int empid) 
	{
		employeeRepository.deleteById(empid);
	}
	public void updateRecord(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public List<Employee> getList() 
	{
		return employeeRepository.findAll();
	}
	public List<String> getDepartmentList() 
	{
		return employeeRepository.getDepartmentNameList();
	}
	public List<Employee> getListDepartmentWise(String department) 
	{
		return employeeRepository.findByDepartment(department);
	}
}
