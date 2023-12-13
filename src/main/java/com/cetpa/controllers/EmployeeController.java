package com.cetpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.entities.Employee;
import com.cetpa.services.EmployeeService;

@Controller
@RequestMapping("employee-management")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping("")
	public String getHomeView()
	{
		return "home";
	}
	@RequestMapping("insert")
	public String getInsertView()
	{
		return "insert-employee";
	}
	@RequestMapping("save-record")
	public String saveEmployee(Employee employee,Model model)
	{
		int empid=employee.getEmpid();
		Employee emp=employeeService.getEmployee(empid);
		if(emp!=null)
		{
			model.addAttribute("empid",empid);
			return "save-fail";
		}
		employeeService.saveRecord(employee);
		return "save";
	}
	@RequestMapping("search")
	public String getSearchView()
	{
		return "search-employee";
	}
	@RequestMapping("search-record")
	public String getEmployee(int eid,Model model)
	{
		Employee emp=employeeService.getEmployee(eid);
		if(emp==null)
		{
			model.addAttribute("msg","Employee with id "+eid+" not found");
			return "search-employee";
		}
		model.addAttribute("employee",emp);
		return "show-employee";
	}
	@RequestMapping("delete")
	public String getDeleteView()
	{
		return "delete-employee";
	}
	@RequestMapping("delete-record")
	public String deleteEmployee(int eid,Model model)
	{
		Employee emp=employeeService.getEmployee(eid);
		if(emp==null)
		{
			model.addAttribute("msg","Employee with id "+eid+" does not exist");
			return "delete-employee";
		}
		employeeService.deleteRecord(eid);
		model.addAttribute("msg","Employee with id "+eid+" has been deleted");
		return "delete-employee";
	}
	@RequestMapping("edit")
	public String getEditView()
	{
		return "edit-employee";
	}
	@RequestMapping("show-record")
	public String showEmployee(int eid,Model model)
	{
		Employee emp=employeeService.getEmployee(eid);
		if(emp==null)
		{
			model.addAttribute("msg","Employee with id "+eid+" does not exist");
			return "edit-employee";
		}
		model.addAttribute("employee",emp);
		return "update-employee";
	}
	@RequestMapping("update-record")
	public String updateEmployee(Employee employee,Model model)
	{
		employeeService.updateRecord(employee);
		return "update";
	}
	@RequestMapping("list")
	public String getEmployeeList(Model model)
	{
		List<Employee> list=employeeService.getList();
		model.addAttribute("elist",list);
		return "employee-list";
	}
	@RequestMapping("search-by-dept")
	public String getEmployeeDepartmentList(Model model)
	{
		List<String> list=employeeService.getDepartmentList();
		model.addAttribute("dlist",list);
		return "search-employee-bydept";
	}
	@RequestMapping("show-records")
	public String getEmployeeListDepartmentWise(String department,Model model)
	{
		List<Employee> list=employeeService.getListDepartmentWise(department);
		model.addAttribute("elist",list);
		return "employee-list";
	}
}
