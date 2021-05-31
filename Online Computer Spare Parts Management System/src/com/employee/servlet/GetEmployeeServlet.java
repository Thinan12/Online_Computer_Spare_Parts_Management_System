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


public class GetEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public GetEmployeeServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String employeeID = request.getParameter("employeeID");			
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		Employee employee = iEmployeeService.getEmployeeByID(employeeID);

		request.setAttribute("employee", employee);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetEmployee.jsp");
		dispatcher.forward(request, response);
	}

}
