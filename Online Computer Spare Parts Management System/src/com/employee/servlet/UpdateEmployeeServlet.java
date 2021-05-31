package com.employee.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.model.Employee;
import com.employee.service.EmployeeServiceImpl;
import com.employee.service.IEmployeeService;


public class UpdateEmployeeServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public UpdateEmployeeServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Employee employee = new Employee();
		String employeeID = request.getParameter("employeeID");	
		employee.setEmployeeID(employeeID);
		employee.setName(request.getParameter("employeeName"));
		employee.setAddress(request.getParameter("address"));
		employee.setDesignation(request.getParameter("designation"));
		employee.setBranch(request.getParameter("branch"));
		employee.setMobileNumber(request.getParameter("mobilenumber"));
		employee.setPassword(request.getParameter("Password"));
		employee.setGender(request.getParameter("gender"));
		
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		iEmployeeService.updateEmployee(employeeID, employee);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
