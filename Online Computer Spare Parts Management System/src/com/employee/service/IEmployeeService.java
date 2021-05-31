package com.employee.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.employee.model.Employee;


public interface IEmployeeService {


	public static final Logger log = Logger.getLogger(IEmployeeService.class.getName());


	public void addEmployee(Employee employee);


	public Employee getEmployeeByID(String empoyeeID);
	

	public ArrayList<Employee> getEmployees();
	
	public Employee updateEmployee(String employeeID, Employee employee);

	public void removeEmployee(String employeeID);

}
