package com.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.*;
import com.product.service.*;
import com.product.service.*;

public class AddProductServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public AddProductServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Product product = new Product();
		
		product.setProductName(request.getParameter("productName"));
		product.setProductPrice(request.getParameter("productPrice"));
		product.setQuantity(request.getParameter("quantity"));
		product.setWarrantyperiod(request.getParameter("warrantyperiod"));
		product.setSpecification(request.getParameter("specification"));
		product.setStatus(request.getParameter("status"));

		IProductService iProductService = new ProductServiceImpl();
		iProductService.addProduct(product);

		request.setAttribute("product", product);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListProduct.jsp");
		dispatcher.forward(request, response);
	}

}
