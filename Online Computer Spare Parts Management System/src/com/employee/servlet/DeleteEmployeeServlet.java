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


public class DeleteEmployeeServlet extends HttpServlet {


	private static final long serialVersionUID = 1871871796669342804L;


	public DeleteEmployeeServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Alla gatta");
		response.setContentType("text/html");

		String employeeID = request.getParameter("employeeID2");	
		System.out.println(employeeID);
		
		IEmployeeService iEmployeeService = new EmployeeServiceImpl();
		iEmployeeService.removeEmployee(employeeID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListEmployees.jsp");
		dispatcher.forward(request, response);
	}

}
