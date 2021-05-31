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


public class UpdateSupplierServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public UpdateSupplierServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		Supplier supplier = new Supplier();
		String supplierID = request.getParameter("supplierID");	
		supplier.setSupplierID(supplierID);
		supplier.setSupplierName(request.getParameter("supplierName"));
		supplier.setCompanyName(request.getParameter("companyname"));
		supplier.setContactNo(request.getParameter("contactno"));
		supplier.setAddress(request.getParameter("address"));
		supplier.setTypes(request.getParameter("type"));
		
		System.out.println(supplier.getCompanyName());
		System.out.println("servelet "+ supplierID);
		
		ISupplierService iSupplierService = new SupplierServiceImpl();
		iSupplierService.updateSuppliers(supplierID, supplier);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListSupplier.jsp");
		dispatcher.forward(request, response);
	}

}
