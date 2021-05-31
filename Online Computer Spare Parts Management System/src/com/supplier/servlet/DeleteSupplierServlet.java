package com.supplier.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supplier.model.Supplier;
import com.supplier.service.SupplierServiceImpl;
import com.supplier.service.ISupplierService;


public class DeleteSupplierServlet extends HttpServlet {


	private static final long serialVersionUID = 1871871796669342804L;


	public DeleteSupplierServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String supplierID = request.getParameter("supplierID");			
		
		ISupplierService iSupplierService = new SupplierServiceImpl();
		iSupplierService.removeSupplier(supplierID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListSupplier.jsp");
		dispatcher.forward(request, response);
	}

}
