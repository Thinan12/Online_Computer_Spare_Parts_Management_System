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

public class GetProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetProductServlet() {
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
		Product product = iProductService.getProductByID(productID);

		request.setAttribute("product", product);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetProduct.jsp");
		dispatcher.forward(request, response);
	}

}
