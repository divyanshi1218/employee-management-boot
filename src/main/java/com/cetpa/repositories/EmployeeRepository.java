package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cetpa.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	@Query("select distinct department from Employee")
	List<String> getDepartmentNameList();
	List<Employee> findByDepartment(String department);
	List<Employee> findByName(String str);
}
