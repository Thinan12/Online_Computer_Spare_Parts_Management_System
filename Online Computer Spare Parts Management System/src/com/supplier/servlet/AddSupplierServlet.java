package com.supplier.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supplier.model.*;
import com.supplier.service.*;
import com.supplier.service.*;

public class AddSupplierServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public AddSupplierServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Supplier supplier = new Supplier();
		
		supplier.setSupplierName(request.getParameter("supplierName"));
		supplier.setCompanyName(request.getParameter("companyname"));
		supplier.setContactNo(request.getParameter("contactno"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setTypes(request.getParameter("type"));

		ISupplierService iSupplierService = new SupplierServiceImpl();
		iSupplierService.addSupplier(supplier);

		request.setAttribute("supplier", supplier);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListSupplier.jsp");
		dispatcher.forward(request, response);
	}

}
