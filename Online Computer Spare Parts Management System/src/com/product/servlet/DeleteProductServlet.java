package com.product.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.model.Product;
import com.product.service.ProductServiceImpl;
import com.product.service.IProductService;


public class DeleteProductServlet extends HttpServlet {


	private static final long serialVersionUID = 1871871796669342804L;


	public DeleteProductServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String productID = request.getParameter("productID");			
		
		IProductService iProductService = new ProductServiceImpl();
		iProductService.removeProduct(productID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListProduct.jsp");
		dispatcher.forward(request, response);
	}

}
